from typing import *


def countOperations(n: int, a: List[int], x: int, q: int, queries: List[List[int]]) -> List[int]:
    operations = []
    total_sum = sum(a)

    for query in queries:
        k, y = query

        total_sum -= a[k]
        total_sum += y
        a[k] = y

        ops = (total_sum + n - 1) // n
        operations.append(ops)

    return operations


T = int(input())

test_cases = []

for _ in range(T):
    n = int(input())
    a = list(map(int, input().split()))
    q = int(input())

    queries = []
    for _ in range(q):
        query = list(map(int, input().split()))
        queries.append(query)

    test_cases.append((n, a, x, q, queries))

for case in test_cases:
    n, a, x, q, queries = case
    result = countOperations(n, a, x, q, queries)
    print(*result)
