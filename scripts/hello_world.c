# LANGUAGE: C
# AUTHOR: SAHARSH JAIN
# GITHUB: https://github.com/SAHARSH123

#include<stdio.h>
int main()
{
	printf("Hello World....!!!!");
	return 0;
}

//Another Approach Using Character Variable



#include <stdio.h>
 
int main()
{
  char a = 'H', b = 'e', c = 'l', d = 'o';
  char e = 'w', f = 'r', g = 'd';
 
  printf("%c%c%c%c%c %c%c%c%c%c", a, b, c, c, d, e, d, f, c, g);
 
  return 0;
}

//Another Approach By Storing in String and printing it



#include <stdio.h>
 
int main()
{
  char s1[] = {'H','e','l','l','o',' ','w','o','r','l','d','\0'};
 
  printf("%s\n", s1);
 
  return 0;
}

