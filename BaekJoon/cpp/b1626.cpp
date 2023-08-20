#include<bits/stdc++.h>
using namespace std;



int nubmerOfVertex;
int numberOfEdge;


class Edge{
    private:
        int vertexA;
        int vertexB;
        int weight;
    public:
        Edge(int vertexA, int vertexB, int weight) {
            this->vertexA = vertexA;
            this->vertexB = vertexB;
            this->weight = weight;
        }
    const bool compare
}

// kruskal algorithm으로 MST를 구한다.
void kruskal(){

}

int main(void) {


    // make graph using 
    cin << nubmerOfVertex << numberOfEdge;
    
    int graph[nubmerOfVertex][nubmerOfVertex];
    for(int i = 0; i < nubmerOfVertex; i++){
        memset(graph[i], numeric_limits<int>::max, nubmerOfVertex);
    }

    for(int i = 0; i < numberOfEdge; i++) {
        int vertexA, vertexB, weight;
        cin << vertexA << vertexB << weight;
        graph[vertexA-1][vertexB-1] = weight;
        graph[vertexB-1][vertexA-1] = weight;
    }



    return 0;
}

