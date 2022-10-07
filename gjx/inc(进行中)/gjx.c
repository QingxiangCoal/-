#include <stdio.h>
#include <unistd.h>
char readin(char ts);
int main()
{
//获取当前路径
	char lj[301];
	memset(lj,0,sizeof(lj));
	getcwd(lj,300);

char *ts = "测试";
printf("s%" , readin(*ts));

	return 0;
}
