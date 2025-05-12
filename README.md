<h1 align="center">💰🔄 Conversor de Moedas com API 🔄💰</h1>

<p align="center">
  Desafio proposto pelo Projeto One - Oracle  Education - para os estudantes do curso de BeckEnd.
  Um conversor de moedas simples e eficiente, construído em Java, que busca as taxas de câmbio mais recentes diretamente da API <a href="https://www.exchangerate-api.com/" target="_blank">exchangerate-api.com</a>. Diga adeus às taxas desatualizadas! 👋
</p>

## ✨ Funcionalidades Principais ✨

* **Console Interativo:** Uma experiência de conversão direta e fácil de usar na linha de comandos. ⌨️
* **Várias Opções de Moeda:** Um menu com diversas combinações de moedas populares para você escolher. 🌍
* **Taxas de Câmbio Vivas:** Dados sempre atualizados, trazidos diretamente da API `exchangerate-api.com`. 🚀
* **Tecnologia Google Gson:** Utilizamos a poderosa biblioteca Gson para processar as informações da API em formato JSON. 📦
* **Princípios de POO:** Código bem organizado e fácil de manter, graças à Programação Orientada a Objetos. 🧱
* **Segurança em Primeiro Lugar:** Leitura da sua chave de API através de um ficheiro `.env` (altamente recomendado!) para proteger suas credenciais. 🔒
* **Flexibilidade:** Opção (não recomendada para produção) de incluir a chave diretamente no código para testes rápidos. 🛠️

## 🚀 Como Começar 🚀

1.  **Clone o Repositório:**
    ```bash
    git clone https://github.com/danimariano/CurrencyApp.git
    cd CurrencyApp
    ```

2.  **🔑 Configure sua Chave de API (Método Seguro) 🔑**
    * Crie um ficheiro chamado `.env` na raiz do projeto.
    * Adicione sua chave da `exchangerate-api.com` assim:
        ```
        API_KEY=SUA_CHAVE_DE_API
        ```
        ⚠️ **Importante:** Substitua `SUA_CHAVE_DE_API` pela sua chave real!
    * Certifique-se de adicionar `.env` ao seu `.gitignore` para segurança. 🛡️

3.  **⚙️ Executando o Conversor ⚙️**
    * Certifique-se de ter o Java instalado no seu computador. ☕
    * Abra seu terminal na pasta do projeto.
    * Compile os ficheiros Java:
        ```bash
        javac main/Java/com/example/*.java main/Java/com/example/service/*.java main/Java/com/example/model/*.java
        ```
    * Execute a aplicação:
        ```bash
        java main.Java.com.example.CurrencyConverterApp
        ```
    * Siga as instruções que aparecerão no seu terminal para realizar as conversões! ➡️
      


## 📂 Estrutura do Projeto 📂
convertCurrency/
├── main/

│   └── Java/

│       └── com/

│           └── example/

│               ├── 📄 CurrencyConverterApp.java ✨ (Aplicação Principal)

│               ├── model/

│               │   └── 📄 ExchangeRates.java 📊 (Modelo de Dados da API)

│               └── service/

│                   └── 📄 ExchangeRateService.java 📡 (Serviço de Chamada à API)

├── 🔑 .env (🔒 Opcional: Chave de API - NÃO COMMITAR! 🚫)

├── 📜 .gitignore (📝 Lista de ficheiros ignorados pelo Git)

└── 📄 README.md (📖 Este ficheiro - Guia do Projeto)

## 🛠️ Dependências 🛠️

* **Gson:** A biblioteca mágica do Google para transformar JSON em objetos Java! ✨
* **java-dotenv:** (Opcional) Para carregar suas variáveis de ambiente de forma segura. 🗝️

## ⚠️ Aviso de Segurança ⚠️

Lembre-se: sua chave de API é como uma senha! 🔑 Mantenha-a segura usando o ficheiro `.env` e garantindo que ele não seja enviado para o GitHub. 🚫

## ⏭️ Próximos Passos ⏭️

* Adicionar suporte para mais moedas! ➕
* Permitir que o usuário digite as moedas desejadas. 🤔
* Melhor tratamento de erros para quando a API não responder bem. 😥
* Quem sabe uma interface gráfica no futuro? 🤩

Sinta-se à vontade para explorar o código e contribuir! 😊

