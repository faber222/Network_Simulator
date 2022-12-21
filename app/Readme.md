### Entregas e requisitos para desenvolvimento

Marque com x cada um dos itens que atendeu ao desenvolver este projeto.

- [ ] Diagrama de classes UML salvo com o nome `modelagem.png` na raiz do repositório
- [X] Projeto Java com gradle funcional. Espera-se um repositório com arquivo `.gitignore` correto e que seja possível executar o projeto após o clone
- [X] 1 arquivo texto com a topologia da rede (no mínimo 10 *endpoints* e 4 comutadores)
- [X] 1 arquivo texto com o tráfego a ser simulado (no mínimo 10 pacotes)
- [ ] Criar um diretório com o nome `resultado` e armazenar nele dois arquivos (resultados da execução da sua aplicação tendo como entrada os dois arquivos dos itens anteriores): 
- [X] Resultado gerado pelo objeto de registro (copiar a saída da tela e jogar para dentro do arquivo texto); e 
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

#### - RESUMO DO QUE FOI FEITO

- foi o maximo que consegui, não terminei porque tive que priorizar calculo IV
- caso queira aceitar algo, o código consegue ler o arquivo passado na linha de comando, mas apenas .txt
- consegue calcular os hosts e switchs e atribuir suas ligações
- no pc consegue enviar os pacotes para os switchs e descartar arquivos que não são deles
- switch consegue encaminhar para os vizinhos conhecidos, mas pacotes com origem desconhecidas são descartados
- falta implementar o ttl, calcular rotas para pacotes vizinhos e eliminar da fila pacotes indesejados, que são enviado a todos
- e falta tratar os dados de saida e atribuir resultado, uml, arquivo de texto
- o que foi implementado é apenas visual no terminal

- Concordo que 18 dias foi bastante tempo, mas devido as outras matérias, tive que priorizar, e acabou que a sua ficou por ultimo
- Caso aceite algo, abaixo de 3 eu reprovo e faço novamente com você semestre que vem