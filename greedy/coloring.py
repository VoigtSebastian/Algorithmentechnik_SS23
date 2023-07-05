#! /usr/bin/env python3


a = [[0, 1, 0, 1], [1, 0, 0, 1], [0, 0, 0, 1], [1, 1, 1, 0]]
n = len(a)
c = [-1] * n


for i in range(0, n):
    cc = 0
    while True:
        c[i] = cc
        cc += 1
        color_found = True
        for j in range(0, n):
            if a[i][j] == 1 and c[i] == c[j] and c[i] != -1:
                color_found = False
                break
        if color_found:
            break

print(c)
