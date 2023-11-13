import Bomb
from tkinter import simpledialog

a = list(range(1, 10))
i = 0
while i < len(a):
  print("even" if a[i] % 2 == 0 else "odd")
  i += 1

# rand = int(random.random() * 100) + 1
# cnt = 0;
# print(rand)
# while True:
#   input = simpledialog.askinteger("Input", "Your Answer?", parent=None)
#   cnt += 1
#   if (input > rand):
#     print('큽니다')
#   elif (input < rand):
#     print('작습니다')
#   else:
#     print(f"정답입니다. {cnt}번 만에 맞췄습니다.")
#     break

b = Bomb.Bomb()
b.start()
print(b.life)
answer = simpledialog.askstring(
  "Select", "Which do you want red(1) or blue(2)?",parent=None)
b.choose(answer)



print()
print()
print()
print()
print()
print()
print()
print()
print()
print()
print()
