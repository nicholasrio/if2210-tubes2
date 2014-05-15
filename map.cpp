#include <cstdio>
#include <string>
#include <iostream>
using namespace std;
int main() {
	FILE *f = fopen("map", "w");
	string inp;
	int count = 0;
	while (true) {
		cout << "Command : ";
		cin >> inp;
		if (inp == "exit")
			break;
			
			
		if (inp == "tower") {
			int num;
			cin >> num;
			for (int it = 0; it < num; ++it) {
				if (count % 20 == 0)
					fprintf(f, "\n");
				else
					fprintf(f, " ");
					
				fprintf(f, "256");
				count++;
			}
		}
		else if (inp == "jalan") {
			if (count % 20 == 0)
				fprintf(f, "\n");
			else
				fprintf(f, " ");
				
			string dir;
			int dir_int = 0; 
			while (true) {
			cout << "Jalan : ";
				cin >> dir;
				if (dir == "e")
					break;
				if (dir == "mr")
					dir_int |= 1;
				if (dir == "mu")
					dir_int |= 1<<1;
				if (dir == "ml")
					dir_int |= 1<<2;
				if (dir == "md")
					dir_int |= 1<<3;
				if (dir == "r")
					dir_int |= 1<<4;
				if (dir == "u")
					dir_int |= 1<<5;
				if (dir == "l")
					dir_int |= 1<<6;
				if (dir == "d")
					dir_int |= 1<<7;
			}
			fprintf(f, "%d", dir_int);
			count++;
		}
	}
	fclose(f);
	return 0;
}