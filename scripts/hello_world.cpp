/*
 LANGUAGE: C++
 AUTHOR:		Anshul Singh
 GITHUB:		https://github.com/iosdev747
*/
#include<iostream>
using namespace std;
int main(){
	char hola[]={'H','e','l','l','o',' ','W','o','r','l','d'};
	for(int i=0;i<(sizeof(hola)/sizeof(hola[0]));i++)
	{
	cout<<hola[i];
	}
	return 0;
}
