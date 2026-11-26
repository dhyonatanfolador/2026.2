
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

/* Inicializa a lista vazia. */
void List_init(List *L) {
    L->begin = NULL;
    L->end = NULL;
    L->size = 0;
}

/* Insere um valor no final da lista. */
void List_insert_end(List *L, int val) {
    Node *novo = malloc(sizeof(Node));

    if (novo == NULL) {
        printf("Erro ao alocar memoria.\n");
        exit(EXIT_FAILURE);
    }

    novo->val = val;
    novo->prev = L->end;
    novo->next = NULL;

    if (L->end == NULL) {
        L->begin = novo;
    } else {
        L->end->next = novo;
    }

    L->end = novo;
    L->size++;
}

/* Insere um valor no início da lista. */
void List_insert_begin(List *L, int val) {
    Node *novo = malloc(sizeof(Node));

    if (novo == NULL) {
        printf("Erro ao alocar memoria.\n");
        exit(EXIT_FAILURE);
    }

    novo->val = val;
    novo->prev = NULL;
    novo->next = L->begin;

    if (L->begin == NULL) {
        L->end = novo;
    } else {
        L->begin->prev = novo;
    }

    L->begin = novo;
    L->size++;
}

/* Remove a primeira ocorrência de um valor. */
void List_remove_val(List *L, int val) {
    if (L == NULL) {
        return;
    }

    Node *atual = L->begin;

    while (atual != NULL && atual->val != val) {
        atual = atual->next;
    }

    if (atual == NULL) {
        return;
    }

    if (atual->prev != NULL) {
        atual->prev->next = atual->next;
    } else {
        L->begin = atual->next;
    }

    if (atual->next != NULL) {
        atual->next->prev = atual->prev;
    } else {
        L->end = atual->prev;
    }

    free(atual);
    L->size--;
}

/* Retorna o último valor da lista. */
int List_get_last_val(const List *L) {
    if (L == NULL || L->end == NULL) {
        return -1;
    }

    return L->end->val;
}

/* Remove o último elemento da lista. */
void List_remove_last(List *L) {
    if (L == NULL || L->end == NULL) {
        return;
    }

    Node *remover = L->end;

    L->end = remover->prev;

    if (L->end == NULL) {
        L->begin = NULL;
    } else {
        L->end->next = NULL;
    }

    free(remover);
    L->size--;
}

/* Imprime a lista do início ao fim. */
void List_print_forward(const List *L) {
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
void List_print_backward(const List *L) {
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
    if (L == NULL) {
        return;
    }

    Node *atual = L->begin;

    while (atual != NULL) {
        Node *proximo = atual->next;
        free(atual);
        atual = proximo;
    }

    L->begin = NULL;
    L->end = NULL;
    L->size = 0;
}


/* QUESTÃO 2 - TESTE */
int main(void) {
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
