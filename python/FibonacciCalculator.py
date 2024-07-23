def fibonacci(n):
    if n <= 1:
        return n
    fib = [0] * (n + 1)
    fib[0] = 0
    fib[1] = 1
    for i in range(2, n + 1):
        fib[i] = fib[i - 1] + fib[i - 2]
    return fib[n]

import time

n = 40
start_time = time.time()
result = fibonacci(n)
end_time = time.time()
print("Fibonacci({}) = {}".format(n, result))
print("Time taken: {} s".format(end_time - start_time))