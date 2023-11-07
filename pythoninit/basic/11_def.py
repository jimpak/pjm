# def : define
# 중복된 코드를 줄일 수 있고, 코드의 가독성을 높이고, 유지보수성을 향상
# 기능들의 묶음

# 1) 함수 정의(매개변수 없고, 리턴타입 없음)

def lines():
    print("==" * 12)

# 2) 함수 정의(매개변수 있고, 리턴타입 없음)
def lines(str):
    print(f'{str:=^30}')
lines() # 파이썬에서는 overloading이 없기 때문에 최종 함수로 적용
lines("def")

#3) 함수 정의(매개변수가 없고, 리턴타입 있음)
def lines():
  return f"{'':=^30}"
print(lines())

#4) 함수 정의(매개변수가 있고, 리턴타입 있음)
def lines(str):
  return f"{" "+str+" ":=^30}"
print(lines("python"))