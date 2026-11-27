
/*
Disciplina: Estruturas de Dados
Atividade: TPE 2
Estudante: Dhyonatan Folador
Data: 23/11/2026

Objetivo:
Implementar e testar operações de uma lista duplamente encadeada,
mantendo os ponteiros e o tamanho corretos.
*/

#include <stdio.h>
#include <stdlib.h>

/* Estrutura pre definida */
typedef struct _doubly_node {
    int val;
    struct _doubly_node *prev;
    struct _doubly_node *next;
} Node;

typedef struct _doubly_linked_list {
    Node *begin;
    Node *end;
    size_t size;
} List;


/* Funções de apoio utilizadas para preparar e testar a lista. */
/* Inicia a lista vazia. */
void List_init(List *L) {
    L->begin = NULL;
    L->end = NULL;
    L->size = 0;
}

/* Adiciona um valor no final da lista. */
void List_insert_end(List *L, int val) {
    Node *novo = malloc(sizeof(Node));

    if (novo == NULL) {
        printf("Erro\n");
        exit(1);
    }

    novo->val = val;
    novo->next = NULL;

    if (L->size == 0) {
        novo->prev = NULL;
        L->begin = novo;
        L->end = novo;
    } else {
        novo->prev = L->end;
        L->end->next = novo;
        L->end = novo;
    }

    L->size++;
}

/* Adiciona um valor no início da lista. */
void List_insert_begin(List *L, int val) {
    Node *novo = malloc(sizeof(Node));

    if (novo == NULL) {
        printf("Erro\n");
        exit(1);
    }

    novo->val = val;
    novo->prev = NULL;

    if (L->size == 0) {
        novo->next = NULL;
        L->begin = novo;
        L->end = novo;
    } else {
        novo->next = L->begin;
        L->begin->prev = novo;
        L->begin = novo;
    }

    L->size++;
}

/* Remove a primeira ocorrência de um valor. */
void List_remove_val(List *L, int val) {
    Node *atual = L->begin;

    while (atual != NULL && atual->val != val) {
        atual = atual->next;
    }

    if (atual == NULL) {
        return;
    }

    if (L->size == 1) {
        L->begin = NULL;
        L->end = NULL;
    } else if (atual == L->begin) {
        L->begin = atual->next;
        L->begin->prev = NULL;
    } else if (atual == L->end) {
        L->end = atual->prev;
        L->end->next = NULL;
    } else {
        atual->prev->next = atual->next;
        atual->next->prev = atual->prev;
    }

    free(atual);
    L->size--;
}

/* Retorna o último valor da lista. */
int List_get_last_val(List *L) {
    if (L->size == 0) {
        return -1;
    }

    return L->end->val;
}

/* Remove o último elemento da lista. */
void List_remove_last(List *L) {
    Node *remover;

    if (L->size == 0) {
        return;
    }

    remover = L->end;

    if (L->size == 1) {
        L->begin = NULL;
        L->end = NULL;
    } else {
        L->end = remover->prev;
        L->end->next = NULL;
    }

    free(remover);
    L->size--;
}

/* Imprime a lista do início ao fim. */
void List_print_forward(List *L) {
    Node *atual = L->begin;

    while (atual != NULL) {
        printf("%d", atual->val);

        if (atual->next != NULL) {
            printf(" <-> ");
        }

        atual = atual->next;
    }

    printf("\n");
}

/* Imprime a lista do fim para o início. */
void List_print_backward(List *L) {
    Node *atual = L->end;

    while (atual != NULL) {
        printf("%d", atual->val);

        if (atual->prev != NULL) {
            printf(" <-> ");
        }

        atual = atual->prev;
    }

    printf("\n");
}

/* Função que libera todos os nós e deixa a lista vazia. */
void List_clear(List *L) {
    Node *atual = L->begin;
    Node *proximo;

    while (atual != NULL) {
        proximo = atual->next;
        free(atual);
        atual = proximo;
    }

    L->begin = NULL;
    L->end = NULL;
    L->size = 0;
}


/* QUESTÃO 2 - TESTE */
int main() {
    List L;

    List_init(&L);

    List_insert_end(&L, 10);
    List_insert_end(&L, 20);
    List_insert_end(&L, 30);

    List_insert_begin(&L, 5);

    /* Imprime a lista do início para o fim. */
    printf("Lista do inicio para o fim: ");
    List_print_forward(&L);

    /* Imprime a lista do fim para o início. */
    printf("Lista do fim para o inicio: ");
    List_print_backward(&L);

    printf("Ultimo valor: %d\n", List_get_last_val(&L));

    List_remove_last(&L);
    printf("\nDepois de remove_last:\n");
    List_print_forward(&L);

    List_remove_last(&L);
    printf("\nDepois de remove_last:\n");
    List_print_forward(&L);

    List_remove_val(&L, 10);
    printf("\nDepois de remover 10:\n");
    List_print_forward(&L);

    printf("Tamanho final: %zu\n", L.size);

    /* Libera toda a memória utilizada pela lista. */
    List_clear(&L);

    return 0;
}