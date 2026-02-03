# 📝 TodoList

Projeto de **lista de tarefas (ToDo)** desenvolvido em **Java com JPA e MySQL**, com funcionalidades completas de CRUD para gerenciamento de tarefas.

---

## 🚀 Funcionalidades

- Adicionar novas tarefas com título, descrição e status  
- Editar tarefas existentes  
- Alterar status da tarefa (pendente ou concluída)  
- Remover tarefas  
- Listar tarefas ordenadas por ID  
- Persistência de dados com MySQL  

---

## 🛠 Tecnologias Utilizadas

- Java  
- JPA (Jakarta Persistence API)  
- Maven  
- MySQL  
- SQL  

---

## 📦 Estrutura do Projeto

```text
todoList/
├── .idea/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── application/
│   │   │   │   └── Main.java
│   │   │   ├── entities/
│   │   │   │   ├── STATUS.java
│   │   │   │   └── TodoList.java
│   │   │   ├── exceptions/
│   │   │   │   └── DBException.java
│   │   └── resources/
│   │       └── META-INF/
│   │           └── persistence.xml
│   └── test/
├── target/
├── pom.xml
└── .gitignore


```
## ⚙️ Configuração do Banco de Dados

Para executar o projeto, é necessário criar o banco de dados no MySQL.  
A aplicação se encarrega de criar automaticamente as tabelas necessárias.

### Passos:

1. Crie o banco de dados:
```sql
CREATE DATABASE IF NOT EXISTS todoList;
```

2. Configuração das Variáveis de Ambiente

Este projeto utiliza **variáveis de ambiente** para armazenar as credenciais do banco de dados, evitando que usuário e senha fiquem expostos no código.

Antes de executar a aplicação, configure as seguintes variáveis:

- `DB_USER` → seu usuário do MySQL  
- `DB_PASSWORD` → sua senha do MySQL
- `MySQL precisa estar ativo`

### CMD ou Windows (PowerShell):
Escreva primeiro ----
```powershell
setx DB_USER "seu_usuario"
```
Depois escreva ----
```powershell
setx DB_PASSWORD "sua_senha"
```

## ▶️ Executando o Projeto

1. Certifique-se de que o **MySQL esteja em execução**
2. Configure as variáveis de ambiente
3. Abra o projeto na IDE
4. Vá até o arquivo:

```text
src/main/java/application/Main.java
```

Para rodar o projeto, vá na pasta application no arquivo Main e aperte CTRL + F5.

É importante seguir as instruções do terminal 😁

## 🙋🏽 Desenvolvedor
1. Níkolas Kaio S. da Mota

Linkedin: https://www.linkedin.com/in/nikolas-kaio-sandoval-da-mota/



