#include <stdio.h>
#include <assert.h>

struct list{
    int d;
    int c;
    struct list* next;
    struct list* prev;
    struct list* tail;
};

struct list* create(int d, int c){
    struct list* lista = (struct list*)malloc(sizeof(struct list));
    lista->d=d;
    lista->c=c;
    lista->tail=lista;
    return lista;
}

struct list* append(struct list* l, int d, int c){
    struct list *cola=l->tail;
    cola->next=create(d, c);
    (cola->next)->prev=cola;
    l->tail=cola->next;
    return l->tail;
}

struct list* prepend(struct list* l,int d, int c)
{
    struct list* new_node = create(d,c);
    l->prev=new_node;
    new_node->next=l;
    new_node->tail=l->tail;
    return new_node;
}

int maxSubArraySum(struct list* a, int c, int k) 
{ 
    int max_so_far = -1001, max_ending_here = 0; 
    struct list* aux=a;
    while(aux!=NULL)
    { 
        if(aux->c<=c+k && aux->c>=c-k){
            max_ending_here = max_ending_here + aux->d;
        }
         
        if (max_so_far < max_ending_here) 
            max_so_far = max_ending_here; 
  
        if (max_ending_here < 0) 
            max_ending_here = 0;
        
        aux=aux->next;
    } 
    return max_so_far; 
} 

int main(){
    int q, a1, a2, a3, i, c=0, ans=0, k;
    struct list* l=NULL;
    scanf("%d %d", &q, &k);
    for(i=0; i<q; i++){
        scanf("%d %d", &a1, &a2);
        c=a2^ans;
        if(l==NULL){
            if(a1==1){
                scanf("%d", &a3);
                l=create(a3, c);
            }else if(a1==2){
                scanf("%d", &a3);
                l=create(a3, c);
            }else{
                printf("0\n");
            }
        }else{
            if(a1==1){
                scanf("%d", &a3);
                l=prepend(l, a3, c);
            }else if(a1==2){
                scanf("%d", &a3);
                append(l, a3, c);
            }else{
                ans=maxSubArraySum(l, c, k);
                printf("%d\n", ans);
            }
        }
    }
}