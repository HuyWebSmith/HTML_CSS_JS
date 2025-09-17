#include <stdio.h>
#include <stdlib.h>

#define MAX 50

int n, m, u, v, s, f;
int a[MAX][MAX];
int chuaxet[MAX];
int queue[MAX];
int front, rear;

void BFS(int u)
{
	int i, j;
	printf("%d ", u);
	chuaxet[u] = 0;
	rear++;
	queue[rear] = u;
	while (front != rear)
	{
		front++;
		i = queue[front];
		for (j = 1; j <= n; j++)
		{
			if (a[i][j] == 1 && chuaxet[j])
			{
				printf("%d ", j);
				chuaxet[j] = 0;
				rear++;
				queue[rear] = j;
			}
		}
	}
}

int main()
{
	freopen("input.txt", "r", stdin);
	scanf("%d%d", &n, &m);
	for (int i = 1; i <= m; i++)
	{
		scanf("%d%d", &u, &v);
		a[u][v] = 1;
		a[v][u] = 1;
	}
	scanf("%d%d", &s, &f);
	for (int i = 1; i <= n; i++)
		chuaxet[i] = 1;
	BFS(s);
	if (chuaxet[f])
		printf("Not Found");
	return 0;
}

