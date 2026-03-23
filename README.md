# Projeto de Usuários

Projeto simples desenvolvido para estudo, com o objetivo de praticar consumo de API e organização em camadas.

## 🧠 Sobre

Este projeto consiste em uma aplicação Java que consome uma API REST criada por mim utilizando **FastAPI**.

A aplicação permite operações básicas com usuários, como:

* Listar usuários
* Criar usuários
* Atualizar usuários
* Deletar usuários

## 🏗️ Estrutura

O projeto segue uma organização simples em camadas:

* `controller` → interação com o usuário
* `service` → regras de negócio
* `repository` → comunicação com a API
* `model` → estrutura dos dados

## 🌐 API

A API utilizada está hospedada externamente e foi construída com FastAPI.

Base URL:

```
https://api-basica-em-python.onrender.com
```

## ▶️ Como executar

1. Compile o projeto
2. Execute a classe `Main`
3. Utilize o menu no terminal
