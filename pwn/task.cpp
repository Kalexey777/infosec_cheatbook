#include <iostream>
#include <cstdint>

using namespace std;

int main() {
	cout.setf(ios::fixed);
	cout.precision(1);
	//string s = "\xff\xff\xff\xff\xff\xff\xff\xff ever gonna giv\xff you up!";
	uint64_t s1 = 8027420536511817038;
	uint64_t s2 = 18408016418569285230;
	uint64_t s3 = 2409554582912858400;
	uint64_t* a = &s1;
	uint64_t* b = &s2;
	uint64_t* c = &s3;
	double* d = (double*)(a);
	int64_t* e = (int64_t*)(b);
	uint64_t* f = (uint64_t*)(c);
	//uint64_t* c = (uint64_t*)(a+8);
	//int64_t* d = (int64_t*)(a+16);
	cout << *d << " " << *e << " " << *f;
}
