<img src="https://raw.githubusercontent.com/dsbfelipe/readme-banners/main/images/dio.png">
<img align="right" src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white">

<br>
<br>

Este repositório faz parte do bootcamp GFT Start #7 - Java, oferecido pela Digital Innovation One (DIO). Neste projeto, desenvolvi um jogo de Sudoku com interface gráfica em Java, utilizando Swing.

## 📝 Objetivo do Projeto

O projeto teve como meta desenvolver um jogo de Sudoku totalmente funcional, rodando em ambiente gráfico, onde fosse possível iniciar um novo jogo com números fixos pré-definidos, inserir e remover números, validar o status atual do tabuleiro, garantir que não haja números duplicados em linhas, colunas ou blocos 3x3, além de permitir limpar o jogo mantendo apenas os números fixos. Também foi incluída a funcionalidade de adicionar **números de rascunho** em cada célula, seguindo o modelo solicitado no enunciado do desafio.

Embora o uso de um padrão de arquitetura não fosse exigido, optei por aplicar o que aprendi na faculdade, organizando o código em **camadas separadas** para lógica, interface e controle. Essa escolha ajudou a manter o projeto mais limpo, modular e de fácil manutenção.

Um ponto importante foi lidar com as particularidades do **Swing/JPanel**, que exigiu bastante atenção para renderizar o tabuleiro em uma grade 9x9, atualizar as células dinamicamente e gerenciar a interação entre a interface e o modelo de dados.

## 🔧 Funcionalidades

- Interface gráfica com **Swing** (`JFrame` e `JPanel`).

- Tabuleiro de Sudoku com números fixos e espaços livres.

- Inserção e remoção de números respeitando restrições.

- Visualização do status do jogo, validando duplicações.

- Limpeza do tabuleiro mantendo os números fixos.

- Suporte a **rascunhos** (notas) em cada célula.

- Botões para iniciar, inserir, remover, limpar, verificar status e finalizar o jogo.

## 🗂️ Estrutura do Projeto

O projeto está organizado em três partes:

- **Model:** Define as regras do jogo, estrutura de célula e validação.

- **View:** Implementa a interface gráfica com painéis e botões.

- **Controller:** Gerencia as ações do usuário e conecta a interface com o modelo.

## 💻 Tecnologias

- Java JDK 21

- VSCode

- Git & GitHub

## 💡 Créditos

- Projeto realizado no Bootcamp GFT Start #7 - Java, da plataforma DIO em parceria com a GFT.
- Desafio proposto pelo professor José Luiz Abreu Cardoso Junior.
