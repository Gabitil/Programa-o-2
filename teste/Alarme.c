#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#ifdef _WIN32
#include <windows.h>
#else
#include <unistd.h>
#endif

int main() {
    int hora, minuto;
    printf("Digite a hora (formato 24h): ");
    scanf("%d", &hora);
    printf("Digite o minuto: ");
    scanf("%d", &minuto);

    while (1) {
        time_t now = time(NULL);
        struct tm *local = localtime(&now);
        if (local->tm_hour == hora && local->tm_min == minuto) {
            #ifdef _WIN32
            Beep(1000, 500);
            #else
            printf("\a");
            #endif
            break;
        }
        #ifdef _WIN32
        Sleep(1000);
        #else
        sleep(1);
        #endif
    }

    return 0;
}
