# Bowling score calculator - TDD practice

Exercício prático de TDD com Kata Bowling Score Calculator

## Bowling Kata

> O objetivo é criar uma classe que possa calcular a pontuação total de um jogo de boliche somando os pinos e bônus. O design da classe e as regras do cálculo devem seguir o detalhado abaixo. Ao final desse documento estão exemplo de auxílio no entendimento, os exemplos são reais e seu uso é opcional.

<b>Regras da pontuação:</b>

> Um jogo de boliche possui 10 rodadas. Em cada rodada, o jogador tem 2 chances (jogadas) para derrubar os
10 pinos. Se todos os 10 pinos forem derrubados na primeira jogada essa rodada é encerrada, caso contrário
o jogador tem a direto a uma segunda jogada.

> A pontuação do jogo é a soma total de todos pinos derrubados, a esse total ainda são somadas as
bonificações. Essas bonificações (Strike ou Spare) são dadas a um jogador que derrube todos os 10 pinos:

> `Bônus de Spare: um Spare é quando um jogador derruba todos os 10 pinos em duas jogadas. O bônus por
isso é o número de pinos derrubados na próxima jogada.`

> `Bônus de Strike: um Strike é quando um jogador derruba todos os 10 pinos em uma única primeira jogada.
O bônus por isso é o número de pinos derrubados nas duas próximas jogadas.`

> O valor do bônus sempre depende das próximas jogadas, exceto na última rodada que é diferente de todas
as outras. Ao fazer um Strike ou Spare na 10a rodada, o jogador tem direto a 3 jogadas nessa rodada como
forma de bônus (conforme pode ser visto nos exemplos abaixo).

### Design da classe sugerido:

```java
class CalculadoraPontuacaoBoliche {
  int pontuacaoDoJogo(int[] jogadas) { return 0; }
}
```
---
### Exemplos:

1. Exemplo de um Jogo Completo com Spare e Strike.

`int pinosDerrubados = {1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6};`

`retorno esperado = 133`

2. Exemplo de um Jogo com Strike.

`int pinosDerrubados = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 2, 3, 0, 0};`

`Retorno esperado = 20`

3. Exemplo de um Jogo com Spare.

`int pinosDerrubados = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 8, 2, 3, 0,0};`

`retorno esperado = 17`

4. Exemplo Jogo Perfeito.

`int pinosDerrubados = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};`

`retorno esperado = 300`


#### OBS:
* Os espaços entre os números representam a separação entre as rodadas (sempre são 10 rodadas);
* Os números em negrito são Strike ou Spare;
* Os números sublinhados são os bônus de um Strike ou Spare de uma jogada anterior. Ou seja, esses
números são somados novamente ao resultado total na forma de bônus.

### Solução

A Solução apresentada teve como foco principal,  a prática do TDD e aplicação de princípios Clean Code.
