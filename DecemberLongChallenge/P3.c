#include <stdio.h>
#include <assert.h>


struct list{
    int des;
    int num;
    int dir;
    struct list* next;
    struct list* prev;
    struct list* tail;
    int parent;
};

struct list* create(int data){
    struct list* lista = (struct list*)malloc(sizeof(struct list));
    lista->des=data;
    lista->tail=lista;
    return lista;
}

struct list* apend(struct list* l, int data){
    struct list *cola=l->tail;
    cola->next=create(data);
    (cola->next)->prev=cola;
    l->tail=cola->next;
    return l->tail;
}

struct list* append(struct list* l, int parent,int data){
    struct list *cola=l->tail;
    cola->next=create(data);
    (cola->next)->prev=cola;
    cola->next->parent=parent;
    l->tail=cola->next;
    return l->tail;
}

void pop(struct list* l){
    l->tail=(l->tail)->prev;
    (l->tail)->next=NULL;
}

void assign(struct list* l, int val, int dir){
    l->num=val;
    l->dir=dir;
}

void solve(struct list* l[], int n, int m, int* vertices){
    struct list* order=create(-1);
    DFS(l, order, order->des,vertices,0);


    int edges[m];
    int par[n];
    for(int i=0; i<n; i++){
        par[i]=0;
    }
    int aux1=0, aux2=0;
    struct list* aux=(order->tail);
    for(int i=0; i<n; i++){
        *(vertices+(order->tail)->des)=2;
        //printf("\n%d \n", (order->tail)->des);
        while((l[(order->tail)->des]->tail->des)!=-1){
            //printf("%d, %d \n",l[(order->tail)->des]->tail->des, *(vertices+l[(order->tail)->des]->tail->des));
            if(l[(order->tail)->des]->tail->des==(order->tail)->parent){
                aux1=l[(order->tail)->des]->tail->num;
                aux2=l[(order->tail)->des]->tail->dir;
            }else if(*(vertices+l[(order->tail)->des]->tail->des)!=2){
                //printf("%d \n", l[(order->tail)->des]->tail->num);
                edges[l[(order->tail)->des]->tail->num]=l[(order->tail)->des]->tail->dir;
                par[order->tail->des]++;
            }
            
            pop(l[(order->tail)->des]);
        }
        if(order->tail->parent!=-1){
        if(par[order->tail->des]%2==1){
            //printf("entro! %d %d", aux1, aux2);
            edges[aux1]=aux2;
        }else{
            if(aux2==1){
                edges[aux1]=0;
            }else{
                edges[aux1]=1;
            }
            
            par[(order->tail)->parent]++;
        }
        }
        
        pop(order);
        //printf("\n");
    }
    for(int i=0; i<m; i++){
        printf("%d ", edges[i]);
    }
    printf("\n");
}

void DFS(struct list* l[], struct list* order, int parent, int* vertices ,int index){
    append(order, parent, index);
    struct list* aux= l[index];
    *(vertices+index)=1;
    while(aux!=NULL){
        if((aux->des)!=-1 && vertices[aux->des]==0){
            DFS(l, order, index,vertices,aux->des);
        }
        aux=aux->next;
    }

}



int main(){

    int t, n, m, i, j, u, v;
    scanf("%d",&t);
    for(i=0; i<t; i++){
        scanf("%d %d", &n, &m);
        
        struct list* l[n];
        int* vertices = malloc(n*sizeof(int));
        for(j=0; j<n; j++){
            l[j]=create(-1);
            *(vertices+j)=0;
        }
        int cont=0;
        for(j=0; j<m; j++){
            scanf("%d %d", &u, &v);
            apend(l[u-1], v-1);
            assign(l[u-1]->tail, cont, 1);
            apend(l[v-1], u-1);
            assign(l[v-1]->tail, cont, 0);
            cont++;
        }
        if(m%2==0){
            solve(l, n, m, vertices);
        }else{
            printf("-1\n");
        }
       

    }
    

}