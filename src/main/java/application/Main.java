package application;

import Exceptions.DBException;
import entities.STATUS;
import entities.TodoList;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {
        try (Scanner sc = new Scanner(System.in)) {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("todoList-Jpa");
            EntityManager em = emf.createEntityManager();

            System.out.println("--------- TodoList ---------");
            System.out.println("---- (0) para sair ---------");
            System.out.println("---- (1) ver por Id --------");
            System.out.println("---- (2) adicionar tarefa --");
            System.out.println("---- (3) remover tarefa ----");
            System.out.println("---- (4) atualizar tarefa --");
            System.out.println("---- (5) Mostrar tarefas ---");
            int choice = sc.nextInt();
            sc.nextLine();

            while (choice != 0) {

                if (choice == 1) {
                    try {
                        System.out.print("Informe o ID: ");
                        Integer srcId = sc.nextInt();
                        em.getTransaction().begin();
                        TodoList td = em.find(TodoList.class, srcId);
                        if (td == null) {
                            System.out.println("Tarefa não encontrada");
                        } else {
                            System.out.println("Tarefa encontrada: " + td.toString());
                        }
                        em.getTransaction().commit();
                    } catch (DBException e) {
                        throw new DBException("Erro ao buscar id");
                    }
                }

                if (choice == 2) {
                    try {
                        System.out.println("Adicione uma tarefa");
                        System.out.print("Título: ");
                        String title = sc.nextLine();
                        System.out.print("Descrição: ");
                        String description = sc.nextLine();
                        em.getTransaction().begin();
                        TodoList td = new TodoList(title, description);
                        em.persist(td);
                        em.getTransaction().commit();
                        System.out.println("Tarefa adicionada");
                    } catch (DBException e) {
                        em.getTransaction().rollback();
                        throw new DBException("Erro ao adicionar tarefa");
                    }
                }

                if (choice == 3) {
                    try {
                        System.out.println("Remova a tarefa por Id");
                        System.out.print("Informe o Id: ");
                        Integer srcId = sc.nextInt();
                        TodoList td = em.find(TodoList.class, srcId);
                        if (td != null) {
                            em.getTransaction().begin();
                            em.remove(td);
                            em.getTransaction().commit();
                            System.out.println("Tarefa removida!");
                        } else {
                            System.out.println("Tarefa não encontrada");
                        }
                    } catch (DBException e) {
                        throw new DBException("Erro ao remover tarefa");
                    }
                }

                if (choice == 4) {
                    try {
                        System.out.println("Atualize uma tarefa por Id");
                        System.out.print("Informe o Id: ");
                        int srcId = sc.nextInt();
                        TodoList td = em.find(TodoList.class, srcId);
                        if (td != null) {
                            em.getTransaction().begin();
                            td.setStatus(STATUS.CONCLUIDA);
                            em.getTransaction().commit();
                            System.out.println("Tarefa atualizada");
                        } else {
                            System.out.println("Tarefa não encontrada");
                        }
                    } catch (DBException e) {
                        throw new DBException("Erro ao atualizar tarefa");
                    }
                }

                if (choice == 5){
                    try {
                        System.out.println("---Lista de tarefas ---");
                        List<TodoList> td = em.createQuery("SELECT t FROM TodoList t", TodoList.class).getResultList();
                        for (TodoList t : td){
                            System.out.println(t);
                        }
                    }
                    catch (DBException e){
                        throw new DBException("Erro ao ver todas as tarefas");
                    }
                }

                System.out.println();
                System.out.println();
                System.out.println("--------- TodoList ---------");
                System.out.println("---- (0) para sair ---------");
                System.out.println("---- (1) ver por Id --------");
                System.out.println("---- (2) adicionar tarefa --");
                System.out.println("---- (3) remover tarefa ----");
                System.out.println("---- (4) atualizar tarefa --");
                System.out.println("---- (5) Mostrar tarefas ---");
                choice = sc.nextInt();
                sc.nextLine();
            }
            em.close();
            emf.close();
        }
    }
}
