a = list(range(1,10))
i = 0
while i < len(a):
    print("even" if a[i] % 2 == 0 else "odd")
    i += 1