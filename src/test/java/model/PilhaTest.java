package model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PilhaTest {

    private static Pilha pilha;

    @BeforeAll
    static void setUpBeforeAll() {
        pilha = new Pilha();
    }

    @AfterAll
    static void tearDownAfterAll() {
        pilha = null;
        System.out.println("Executou o @AfterAll");
    }

    @BeforeEach
    public void setUp() {
        pilha.push(new Livro("A Terra"));
        pilha.push(new Livro("A Roda"));
        pilha.push(new Livro("A Fazenda"));
        pilha.push(new Livro("O homem que não amava as mulheres"));
    }

    @AfterEach
    public void tearDown(){
        while (pilha.count() > 0){
            pilha.removeLivro();
        }
    }

    @Test
    @DisplayName("Testa método push")
    void testPush() {
        pilha.push(new Livro("A Indomada"));

        assertAll(() -> assertEquals(5, pilha.count()),
                () -> assertEquals("A Indomada", pilha.getLivro().getTitulo())
        );
    }

    @Test
    @DisplayName("Adicionar livro fora do padrão de título")
    void testAdicionarLivroForaPadraoNome(){
        pilha.push(new Livro("Homem de Gelo"));

        assertEquals(4, pilha.count());
    }

    @Test
    @DisplayName("Remover Todos os Livros")
    void testRemoveTodosOsLivros(){
        while (pilha.count() > 0)
            pilha.removeLivro();

        assertEquals(0, pilha.count());
    }

    @Test
    @DisplayName("Remove um livro")
    void testRemoveUmLivro(){
        pilha.removeLivro();

        assertEquals(3, pilha.count());
    }

    @Test
    @DisplayName("Retorna ultimo livro")
    void testRetornaUltimoLivro(){
        assertEquals("O homem que não amava as mulheres", pilha.getLivro().getTitulo());
    }

    @Test
    @DisplayName("Não adiciona além do limite")
    void testNaoAdicionaAlemDoLimite(){
        pilha.push(new Livro("O Game of Thrones"));
        pilha.push(new Livro("A livraria"));

        assertAll(() -> assertEquals(5, pilha.count()),
                () -> assertEquals("O Game of Thrones", pilha.getLivro().getTitulo())
        );
    }

    @Test
    @DisplayName("Não case sensitive")
    void testIgnoraCaseSensitive(){
        pilha.push(new Livro("a Indomada"));

        assertEquals("a Indomada", pilha.getLivro().getTitulo());
    }
}