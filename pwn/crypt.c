#include <stdio.h>
#include <crypt.h>
#include <string.h>

int main() {
	char pass[5] = "guest";
	char* crt = crypt(pass);
	printf("%s", crt);
}
