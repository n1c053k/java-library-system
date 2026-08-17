import Library.Library;

void main() {
    IO.println("Biblioteca de livros");
    IO.println(String.format("[%d] Cadastrar livro", 1));
    IO.println(String.format("[%d] Remover livro", 2));
    IO.println(String.format("[%d] Listar livros", 3));
    IO.println(String.format("[%d] Cadastrar usuário", 4));
    IO.println(String.format("[%d] Emprestar livro", 5));
    IO.println(String.format("[%d] Devolver livro", 6));
    IO.println(String.format("[%d] Sair", 7));

    Library library = new Library();

    boolean exit = false;

    while (!exit) {
        String choice = IO.readln("Digite a ação desejada: ");
        if (choice == null) {
            IO.println("Alternativa inválida");
            return;
        }

        int numChoice = 0;

        try
        {
            numChoice = Integer.parseInt(choice) - 1;
            if (numChoice < 0 || numChoice > 6) {
                IO.println("Alternativa inválida");
                return;
            }
        }
        catch (NumberFormatException e)
        {
            IO.println("ID inválido");
            return;
        }

        switch (numChoice) {
            case 0: {
                String title = IO.readln("Título do livro: ");
                String author = IO.readln("Autor do livro: ");
                library.registerBook(title, author);
                break;
            }
            case 1: {
                String id = IO.readln("ID do livro: ");
                try
                {
                    int parsedId = Integer.parseInt(id);
                    library.deleteBook(parsedId);
                }
                catch (NumberFormatException e)
                {
                    IO.println("ID inválido");
                }
                break;
            }
            case 2: {
                library.printBooks();
                break;
            }
            case 3: {
                String name = IO.readln("Nome do usuário: ");
                library.registerUser(name);
                break;
            }
            case 4: {
                String bookId = IO.readln("ID do livro: ");
                String userId = IO.readln("ID do usuário: ");

                try
                {
                    int parsedBookId = Integer.parseInt(bookId);
                    int parsedUserId = Integer.parseInt(userId);
                    library.borrowBook(parsedBookId, parsedUserId);
                }
                catch (NumberFormatException e)
                {
                    IO.println("ID inválido");
                }

                break;
            }
            case 5: {
                String bookId = IO.readln("ID do livro: ");
                String userId = IO.readln("ID do usuário: ");

                try
                {
                    int parsedBookId = Integer.parseInt(bookId);
                    int parsedUserId = Integer.parseInt(userId);
                    library.returnBook(parsedBookId, parsedUserId);
                }
                catch (NumberFormatException e)
                {
                    IO.println("ID inválido");
                }

                break;
            }
            case 6:
            {
                exit = true;
                break;
            }
            default:
            {
                IO.println("Ação inválida");
                break;
            }
        }
    }
}

