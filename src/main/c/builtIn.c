int scanf(const char *format, ...);

int printf(const char *format, ...);

int sprintf(char *str, const char *format, ...);

void *malloc(unsigned int size); // NOLINT

void print(char *s) { printf("%s", s); }

void println(char *s) { printf("%s\n", s); }

void printInt(int n) { printf("%d", n); }

void printlnInt(int n) { printf("%d\n", n); }

char *getString() {
  char *s = (char *) malloc(sizeof(char) * 1024);
  scanf("%s", s);
  return s;
}

int getInt() {
  int n;
  scanf("%d", &n);
  return n;
}

char *toString(int i) {
  char *s;
  s = (char *) malloc(sizeof(char) * 12);
  sprintf(s, "%d", i);
  return s;
}

void *__array_alloca(int size, int length) {
  int *a = (int *) malloc(size * length + 4);
  a[0] = length;
  return a + 1;
}

int __builtIn_array_size(void *array) { return ((int *)array)[-1]; }

int __string_length(char *s) {
  int i = 0;
  while (s[i] != '\0') {
    i++;
  }
  return i;
}

char *__string_substring(char *s, int left, int right) {
  int len = right - left;
  char *result = (char *) malloc(sizeof(char) * (len + 1));
  for (int i = 0; i < len; i++) {
    result[i] = s[left + i];
  }
  result[len] = '\0';
  return result;
}

int __string_parseInt(char *s) {
  int result = 0;
  int i = 0;
  if (s[0] == '-') i = 1;
  for (; s[i] != '\0'; i++) {
    result = result * 10 + s[i] - '0';
  }
  if (s[0] == '-') {
    result = -result;
  }
  return result;
}

int __string_ord(char *s, int i) { return s[i]; }

int __string_compare(char *s1, char *s2) {
  int i = 0;
  while (s1[i] != '\0' && s2[i] != '\0') {
    if (s1[i] != s2[i]) {
      return s1[i] - s2[i];
    }
    i++;
  }
  return s1[i] - s2[i];
}

char *__string_concat(char *s1, char *s2) {
  int len1 = __string_length(s1);
  int len2 = __string_length(s2);
  char *result = (char *) malloc(sizeof(char) * (len1 + len2 + 1));
  for (int i = 0; i < len1; i++) {
    result[i] = s1[i];
  }
  for (int i = 0; i < len2; i++) {
    result[len1 + i] = s2[i];
  }
  result[len1 + len2] = '\0';
  return result;
}

void __string_copy(char **s1, char *s2) {
  int len = __string_length(s2);
  *s1 = (char *) malloc(sizeof(char) * (len + 1));
  for (int i = 0; i < len; i++) {
    (*s1)[i] = s2[i];
  }
  (*s1)[len] = '\0';
}