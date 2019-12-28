# Android Architecture MVVM 

Esse repositório foi criado com o objetivo de instruir boas práticas para o desenvolvimento Android visando um código mais legível. Ele é utilizado internamente pela equipe de desenvolvimento de APPs da Crosoften Tecnologia e Inovação com o propositório de padronizar, estruturar e manter uma melhor qualidade de código.

## Arquitetura do projeto

Durante nossos projetos utilizamos o conceito de [Model-View-ViewModel (ou MVVM),](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel) com algumas pequenas modificações para melhor se adequar ao nosso ambiente.


```
br.com.crosoften.project
├─ commom
├─ data
   ├─ dao
   ├─ database
   └─ entities
├─ di
   ├─ base
   ├─ component
   └─ module
├─ network
   ├─ model
   └─ services   
├─ services
├─ utils
├─ view
   ├─ activities
   ├─ adapters
   ├─ animations
   ├─ custom
   ├─ dialogs
   └─ fragments
└─ viewmodel
```
```commom```: Camada referente a classes comums ao projeto, classes de domínio geral.

```data``` : É a camada responsavel por acessar o banco de dados. Dentro dela temos.

```dao``` : Camada de interfaces contendo os métodos de manipulação das entidades no banco.

```database``` : Camada de configuração do banco de dados.

```entities``` : Camada de entidades criadas no banco.

```di``` : Camada responsável pelo controle de Injeção de Dependências. Dentro dela temos.

```base``` : Camada de classes Bases que serão injetadas.

```component``` : Camada de classes Components que irão prover métodos injetáveis.

```module``` : Módulo que fornece todas as dependências necessárias.

```network``` : Camada referente a parte de conexão com Api's Externas. Dentro dela temos:

```model``` : Os modelos são POJOs (Plain Old Java Object) utilizados como comunicadores com WebService.

```services``` : Camada de Interfaces que fornecem métodos comunicáveis com os webservices e injetados nas respectivas camadas de viewModel.

```services```: Camada de Interfaces a serem utilizadas durante a aplicação.

```utils```: Classes que não pertencem a nenhum grupo anterior, classes váriadas, podem ser guardadas no pacote útils. Por exemplo, uma classe para formatar datas (DataUtils).

```view```: Responsável por guardar as activities, fragments, adapters, animations, customs, dialogs, fragments, notifications, dentre outros . Basicamente, tudo relacionado a View do aplicativo.

```viewmodel```: Camada responsável pela parte lógica e a conexão entre a camada de view e a camada model.

# Bibliotecas Padrões que são Utilizadas
* [Material Design](https://material.io/develop/android/docs/getting-started/)

Biblioteca Utilizada de acordo com os padrões estabelecidos pelo Material Design, na construção de Layouts, Animações, por se tratar de uma biblioteca que faz parte do conjunto de componentes de arquitetura do JetPack.

* [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle)

Os componentes que reconhecem o ciclo de vida executam ações em resposta a uma mudança no status do ciclo de vida de outro componente, como atividades e fragmentos. Esses componentes ajudam você a produzir códigos mais organizados e, com frequência, mais leves, mais fáceis de manter. Componentes Utilizados: LiveData e ViewModel.

* [Paging](https://developer.android.com/jetpack/androidx/releases/paging)

A Biblioteca de Paginação facilita o carregamento de dados de forma gradual e elegante no RecyclerView do seu aplicativo . Consulte os documentos de referência para mais informações.

* [Room](https://developer.android.com/jetpack/androidx/releases/room)

A biblioteca de persistência Room fornece uma camada de abstração sobre o SQLite para permitir um acesso mais robusto ao banco de dados enquanto aproveita todo o poder do SQLite. Consulte os documentos de referência para mais informações.

* [Retrofit](https://square.github.io/retrofit/)

Um cliente HTTP de segurança de tipos para Android, Utilizado para comunicação com WebServices.

* [Gson](https://github.com/google/gson)

O Gson é uma biblioteca Java que pode ser usada para converter objetos Java em sua representação JSON. Ele também pode ser usado para converter uma sequência JSON em um objeto Java equivalente. O Gson pode trabalhar com objetos Java arbitrários, incluindo objetos pré-existentes dos quais você não possui código-fonte. Este Utilizado em conjunto com o Retrofit

* [Dagger2](https://github.com/google/dagger)

Um injetor de dependência rápida para Java e Android. Dagger é uma estrutura de tempo de compilação para injeção de dependência. Ele não usa geração de bytecode de reflexão ou de tempo de execução, faz toda a sua análise em tempo de compilação e gera código-fonte Java simples.

* [RxJava](https://github.com/ReactiveX/RxJava)

O RxJava é uma implementação Java VM de Extensões Reativas : uma biblioteca para composição de programas assíncronos e baseados em eventos usando sequências observáveis.

Ele estende o padrão de observador para suportar sequências de dados / eventos e adiciona operadores que permitem compor sequências juntos de forma declarativa, abstraindo preocupações sobre coisas como estruturas de dados de threading de baixo nível, sincronização, thread-safety e concorrentes. Este Utilizado em conjunto com o Retrofit.

* [RxAndroid](https://github.com/ReactiveX/RxAndroid)

Este módulo adiciona as classes mínimas ao RxJava que tornam a gravação de componentes reativos em aplicativos Android fácil e sem complicações. Mais especificamente, fornece um Schedulerprograma que agende no thread principal ou em qualquer dado Looper. Este Utilizado em conjunto com o Retrofit.

* [Data Binding](https://developer.android.com/topic/libraries/data-binding?hl=pt-br)

A Data Binding Library é uma biblioteca de apoio que permite vincular componentes de IU dos seus layouts a fontes de dados do app usando um formato declarativo, em vez de programático.
