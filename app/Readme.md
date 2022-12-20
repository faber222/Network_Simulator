### Entregas e requisitos para desenvolvimento

Marque com x cada um dos itens que atendeu ao desenvolver este projeto.

- [ ] Diagrama de classes UML salvo com o nome `modelagem.png` na raiz do repositório
- [ ] Projeto Java com gradle funcional. Espera-se um repositório com arquivo `.gitignore` correto e que seja possível executar o projeto após o clone
- [X] 1 arquivo texto com a topologia da rede (no mínimo 10 *endpoints* e 4 comutadores)
- [X] 1 arquivo texto com o tráfego a ser simulado (no mínimo 10 pacotes)
- [ ] Criar um diretório com o nome `resultado` e armazenar nele dois arquivos (resultados da execução da sua aplicação tendo como entrada os dois arquivos dos itens anteriores): 
- [ ] Resultado gerado pelo objeto de registro (copiar a saída da tela e jogar para dentro do arquivo texto); e 
- [ ] A tabela com o resumo da simulação (copiar a saída da tela e jogar para dentro do arquivo texto)
- [X] Instruções de como executar o projeto


####  - Instruções de como executar o projeto

```bash
# Clone this project
$ git clone https://github.com/POO29004-classroom/2022-02-projeto-pratico-02-faber222.git

# Access
$ cd 2022-02-projeto-pratico-02-faber222/

# Run the project 
$ gradle run --args "../topologia.txt ../trafego.txt"

```

#### - Quais linhas deveriam ser alteradas para trocar o objeto de persistência (arquivo texto ou imprimir na tela)

- Não implementado ainda.