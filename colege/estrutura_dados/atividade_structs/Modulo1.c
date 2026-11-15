typedef struct _snode {
    int val ;
    struct _snode * next ;
} SNode ;

typedef struct _linked_list {
    SNode * begin ; // primeiro nó
    SNode * end ; // ú ltimo nó
    size_t size ; // quantidade de nós
} LinkedList ;

 