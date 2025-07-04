import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Essa linha define por quanto tempo a anotação @Key estará disponível
// Essa anotação estará disponível em tempo de execução
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Key {
    /*
     * Essa linha cria uma nova anotação personalizada chamada @Key
     *
     * É como criar uma "etiqueta" que você pode colocar em atributos de uma classe para marcar algo especial
     * – nesse caso, um campo que representa a chave primária (como em um banco de dados)
     */
}