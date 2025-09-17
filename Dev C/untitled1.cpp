#include<stdio.h>
typedef struct Dothi{
	int n;
	int a[100][100];
	
}dothi;
typedef struct STACK{
	int array[100];
	int size;
}STACK;
void khoitaoStack(STACK &stack) {
	stack.size = 0;
}

void DayGiaTriVaoStack (STACK &stack, int value) {
	if(stack.size + 1 >= 100) {
		return;
	}
	stack.array[stack.size] = value-1;
	stack.size++;
}

void TimDuongDi (dothi &g, STACK &stack, int i) {
	for (int j = 1; j <= g.n ; j++) {
		if (g.a[i][j] != 0) {
			g.a[i][j] = g.a[j][i] = 0;
			TimDuongDi(g,stack,j);
//			break;
		}
	}
	DayGiaTriVaoStack(stack,i);
}
int tim_bac_cua_dinh(int arr[][100], int n, int dinh)
{
	int bac = 0;
	for(int i=1;i<=n;i++){
		if(arr[dinh][i]!=0)bac++;
	}
	return bac;	
}
void nhap(dothi &g)
{
	int n,m;
	scanf("%d %d",&n,&m);
	g.n = n;
	for(int i=1;i<=n;i++)
		for(int j=1;j<=n;j++)
			g.a[i][j] = 0;
	
	int temp1,temp2;
	for(int i=1;i<=m;i++){
		scanf("%d %d",&temp1,&temp2);
		g.a[temp1][temp2] = 1;
		g.a[temp2][temp1] = 1;
	}
}
int KiemTraChuTrinhEuler (dothi g) {
	int i, j, bac;
	for (i = 1; i <= g.n; i++) {
		bac = 0;
		for (j = 1; j <= g.n; j++) {
			bac += g.a[i][j];
		}
		if (bac % 2)
			return 0;
	}
	int x = 0;
	int flag = 0;
	for (i = 1; i <= g.n; i++) {
		for (j = 1; j <= g.n; j++) {
			if (g.a[i][j] != 0) {
				x = i;
				flag = 1;
				break;
			}
		}
		if(flag==1)
			break;
	}
	dothi temp = g;
	STACK stack;
	khoitaoStack(stack);
	TimDuongDi(temp, stack, x);
	for (i = 0; i < temp.n; i++) {
		for (j = 0; j < temp.n; j++) {
			if (temp.a[i][j] != 0)
				return 0;
		}
	}
	if (stack.array[stack.size - 1] != stack.array[0])
		return 0;
	printf("Yes\n");
	for(i = stack.size - 1; i >= 0 ; i--)
		printf("%d ",stack.array[i] + 1);
	return 1;
}
int KiemTraDuongDiEuler (dothi g) {
	int i,j;
	int x = 0;
	int flag = 0;
	int bac = 0;
	for (i = 1; i <= g.n; i++) {
		bac = 0;
		for (j = 1; j <= g.n; j++) {
			if (g.a[i][j] != 0) {
				bac++;
			}
		}
		if (bac%2 != 0) {
			x = i;
			flag = 1;
			break;
		}
	}
//	if(flag == 0)
//		return 0;
	dothi temp = g;
	STACK stack;
	khoitaoStack (stack);
	TimDuongDi(temp, stack,x);
	for (i = 0; i < temp.n; i++) {
		for (j = 0; j < temp.n; j++) {
			if(temp.a[i][j]!=0)
				return 0;
		}
	}
	if (stack.array[stack.size - 1] == stack.array[0])
		return 0;
	printf("Yes\n");
	for(i = stack.size - 1; i >= 0 ; i--)
		printf("%d ",stack.array[i] + 1);
	return 1;
}
int main()
{
	dothi g;
	nhap(g);
	if (!KiemTraDuongDiEuler(g)&&!KiemTraChuTrinhEuler(g)) {
		printf("No");
	}
	return 0;
}
