/*
Disciplina: Estruturas de Dados
Atividade: TPE 1
Estudante: Dhyonatan Folador
Data: 18/10/2026

Objetivo :
Desenvolver um programa em linguagem C para armazenar e analisar as notas de uma
turma com cinco estudantes.
*/

#include <stdio.h>

/*
Funcao : lerNotas

Objetivo :
Ler as notas e guardar no vetor, e repetir a mensagem caso a nota seja invalida (menor que 0 ou maior que 10).

Parametros :
- notas      : é um vetor para quardar as notas dos estudantes;
- quantidade : serve como limite para o numero de notas que ele irá ler.

Retorno: As notas lidas e armazenadas no vetor
*/
void lerNotas(float notas[], int quantidade) {
    int i;

    for (i = 0; i < quantidade; i++) {
        // Repete ate a nota estar entre 0 e 10
        do {
            printf("Digite a nota do estudante %d: ", i + 1);
            scanf("%f", &notas[i]);

            if (notas[i] < 0 || notas[i] > 10) {
                printf("Nota invalida! Digite entre 0 e 10.\n");
            }
        } while (notas[i] < 0 || notas[i] > 10);
    }
}

/*
Funcao : mostrarNotas

Objetivo :
Mostrar todas as notas do vetor.

Parametros :
- notas      : vetor que contem as notas;
- quantidade : numero de notas.

Retorno: Lista de notas que estavam armazenadas no vetor
*/
void mostrarNotas(float notas[], int quantidade) {
    int i;

    // Percorre o vetor mostrando cada nota
    for (i = 0; i < quantidade; i++) {
        printf("Estudante %d: %.2f\n", i + 1, notas[i]);
    }
}

/*
Funcao : calcularMedia

Objetivo : Calcular a media das notas dos alunos

Parametros :
- notas      : vetor que contem as notas;
- quantidade : numero total de notas

Retorno : A media das notas
*/
float calcularMedia(float notas[], int quantidade) {
    int i;
    float soma = 0;

    // Soma todas as notas
    for (i = 0; i < quantidade; i++) {
        soma = soma + notas[i];
    }

    return soma / quantidade;
}

/*
Funcao : encontrarMaior

Objetivo : Encontrar a maior nota do vetor

Parametros :
- notas      : vetor que contem as notas;
- quantidade : numero de notas.

Retorno : A maior nota
*/
float encontrarMaior(float notas[], int quantidade) {
    int i;
    float maior = notas[0];

    // Compara cada nota com a maior que ja foi encontrada
    for (i = 1; i < quantidade; i++) {
        if (notas[i] > maior) {
            maior = notas[i];
        }
    }

    return maior;
}

/*
Funcao : encontrarMenor

Objetivo : Ele encontra a menor nota do vetor.

Parametros :
- notas      : vetor que contem as notas;
- quantidade : numero de notas.

Retorno : A menor nota
*/
float encontrarMenor(float notas[], int quantidade) {
    int i;
    float menor = notas[0];

    // Compara cada nota com a menor que ja foi encontrada
    for (i = 1; i < quantidade; i++) {
        if (notas[i] < menor) {
            menor = notas[i];
        }
    }

    return menor;
}

/*
Funcao : contarAprovados

Objetivo :
Contar quantos estudantes tiraram nota maior ou igual a 6.

Parametros :
- notas      : vetor que contem as notas;
- quantidade : numero de notas.

Retorno : A quantidade de aprovados
*/
int contarAprovados(float notas[], int quantidade) {
    int i;
    int aprovados = 0;

    // Conta quem tirou 6 ou mais
    for (i = 0; i < quantidade; i++) {
        if (notas[i] >= 6) {
            aprovados++;
        }
    }

    return aprovados;
}

/*
Funcao : contarAcimaDaMedia

Objetivo : Conta quantos estudantes tiraram nota acima da media da turma.

Parametros :
- notas       : vetor que contem as notas
- quantidade  : numero de notas
- media       : media da turma

Retorno :A quantidade de notas acima da media
*/
int contarAcimaDaMedia(float notas[], int quantidade, float media) {
    int i;
    int acima = 0;

    // Conta as notas maiores que a media
    for (i = 0; i < quantidade; i++) {
        if (notas[i] > media) {
            acima++;
        }
    }

    return acima;
}

int main() {
    float notas[5];
    int quantidade = 5;
    float media, maior, menor;
    int aprovados, reprovados, acima;

    // Le as notas
    lerNotas(notas, quantidade);

    // Faz os calculos
    media = calcularMedia(notas, quantidade);
    maior = encontrarMaior(notas, quantidade);
    menor = encontrarMenor(notas, quantidade);
    aprovados = contarAprovados(notas, quantidade);
    reprovados = quantidade - aprovados;
    acima = contarAcimaDaMedia(notas, quantidade, media);


    printf("\n============== RESULTADOS ==============\n");
    printf("Notas cadastradas:\n");
    mostrarNotas(notas, quantidade);
    printf("========================================\n");
    printf("Media da turma: %.2f\n", media);
    printf("Maior nota: %.2f\n", maior);
    printf("Menor nota: %.2f\n", menor);
    printf("Aprovados: %d\n", aprovados);
    printf("Reprovados: %d\n", reprovados);
    printf("Notas acima da media: %d\n", acima);
    printf("========================================\n");

    return 0;
}