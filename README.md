# Java Estudos

Repositório com meus estudos de Java e Programação Orientada a Objetos (POO). Reúne duas frentes:

- **ETEC**: aulas e atividades do curso técnico.
- **Nélio Alves**: exercícios do curso de Java do professor Nélio Alves.

## Estrutura

```
src/
├── etec/
│   ├── aulas/            # exemplos vistos em aula
│   │   ├── abstracao/
│   │   ├── encapsulamento/
│   │   ├── heranca/
│   │   └── interfaces/
│   └── atividades/       # exercícios propostos
│       ├── academia/
│       ├── encapsulamento/
│       ├── heranca/
│       └── polimorfismo/
└── nelio/                # curso do Nélio Alves, uma pasta por seção
```

### ETEC

| Pasta | Conteúdo |
|---|---|
| `etec/aulas` | Exemplos de aula: abstração, encapsulamento, herança e interfaces. |
| `etec/atividades` | Exercícios: academia (alunos e planos de treino), encapsulamento e herança com funcionários, e polimorfismo (animais, overloading e override). |

### Curso do Nélio Alves

Os códigos ficam em `src/nelio`, organizados por seção do curso (por exemplo `secao05_...`), mantendo a ordem das aulas.

## Conceitos praticados

- Abstração
- Encapsulamento
- Herança
- Polimorfismo (sobrecarga e sobrescrita)
- Interfaces
- Enums

## Como executar

Requisitos: **JDK 17 ou superior** (ou a versão configurada no seu projeto).

### Pelo IntelliJ IDEA

1. Abra a pasta do projeto no IntelliJ (`File > Open`).
2. Navegue até a classe `Main` do exercício desejado.
3. Clique no ícone de play ao lado do método `main`.

### Pelo terminal

Na raiz do projeto, compile e execute uma classe pelo nome completo do pacote:

```bash
# compilar tudo para a pasta out
javac -d out $(find src -name "*.java")

# executar uma classe, por exemplo a Main da academia
java -cp out etec.atividades.academia.Main
```

## Autor

Gustavo Deodato