# java-fidelidade-system
Documentação do Projeto Sistema de Fidelidade

Este projeto é uma aplicação Java que modela algumas entidades de um sistema de fidelidade, como Endereço, Cartão de Fidelidade, Cliente e Lançamento de Extrato. Através da definição de classes, atributos e métodos, o sistema permite a manipulação dessas entidades de forma organizada e consistente.

## Classes e seus Atributos

### Endereco:

- logradouro: String
- numero: int
- complemento: String
- cep: String
- cidade: String
- estado: String
- pais: String

### CartaoFidelidade:

- numero: long
- saldo: double
- dataHoraAtualizacao: java.util.Date

### Cliente:

- cpf: String
- nomeCompleto: String
- sexo: br.gov.cesarschool.poo.fidelidade.geral.Sexo
- dataNascimento: java.util.Date
- renda: double
- endereco: br.gov.cesarschool.poo.fidelidade.geral.negocio.Endereco

### LancamentoExtrato:

- numeroCartao: long
- quantidadePontos: int
- dataHoraLancamento: java.util.DateTime

### LancamentoExtratoPontuacao:

- Herda os atributos de LancamentoExtrato.

### LancamentoExtratoResgate:

-Herda os atributos de LancamentoExtrato.
-tipoResgate: br.gov.cesarschool.poo.fidelidade.cartao.negocio.TipoResgate

### Enums:

- Sexo:
- codigo: int
- descricao: String
- valores possíveis: feminino e masculino
- TipoResgate:
- codigo: int
- descricao: String
- valores possíveis: produto, serviço e viagem

## Funcionalidades

### Endereco:

- Construtor Endereco: inicializa todos os atributos da classe.
- Métodos set e get públicos para todos os atributos.

### CartaoFidelidade:

- Construtor CartaoFidelidade: inicializa o número do cartão.
- Métodos get públicos para todos os atributos.
- Método creditar: adiciona ao saldo atual o valor passado como parâmetro e atualiza a dataHoraAtualizacao com a data atual.
- Método debitar: subtrai do saldo atual o valor passado como parâmetro e atualiza a dataHoraAtualizacao com a data atual.

### Cliente:

- Construtor Cliente: inicializa todos os atributos da classe.
- Métodos get públicos para todos os atributos.
- Métodos set públicos para todos os atributos, exceto CPF, que é imutável.
- Método obterIdade: calcula e retorna a idade do cliente em função da data atual e da data de nascimento do cliente.

### LancamentoExtrato:

- Construtor LancamentoExtrato: inicializa todos os atributos da classe.
- Métodos get públicos para todos os atributos.

### LancamentoExtratoPontuacao:

- Herda os métodos e atributos de LancamentoExtrato.

### LancamentoExtratoResgate:

- Herda os métodos e atributos de LancamentoExtrato.
- Método get público para tipoResgate.
Sexo:

- Define os valores possíveis para o atributo sexo da classe Cliente.
TipoResgate:

- Define os valores possíveis para o atributo tipoResgate da classe LancamentoExtratoResgate.

## Conclusão

Além disso, o projeto também conta com duas classes filhas de LancamentoExtrato: LancamentoExtratoPontuacao e LancamentoExtratoResgate. A primeira representa um lançamento de pontos no extrato do cartão de fidelidade e a segunda representa um resgate de pontos. Ambas herdam os atributos e métodos da classe pai.

Por fim, o projeto conta com uma enumeração chamada TipoResgate, que possui três valores possíveis: produto, serviço e viagem.

No geral, o objetivo do projeto é representar um sistema de fidelidade, permitindo a criação de cartões de fidelidade para clientes, bem como o registro de pontos e resgates de pontos em seus respectivos extratos. Além disso, o projeto também possui classes para representar o endereço dos clientes e seu sexo.
