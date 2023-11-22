import pandas as pd
data = {
    '이름': ['유정', '유나', '민영', '은지'],
    '나이': [30, 28, 31, 29],
    '생일': ['1991.5.2', '1193.4.6', '1990.9.12', '1992.7.19']
}
print(type(data))
df1 = pd.DataFrame(data)
print(df1, type(df1), sep='\n')

print()

# 행과 열의 추출
df2 = pd.DataFrame(data, index=['하나', '둘', '셋', '넷']) # 행 이름 변경
print(df2)
print(df2.index)
print(df2.columns)
sr_name = df2['이름'] # 이름 칼럼의 시리즈 추출
print(sr_name, type(sr_name), sep='\n')

print("="*20)
sr_name.name = '브브걸' # 이름 칼럼의 캡션명 변경
sr_name = df2['이름']
print(sr_name)

print("="*20)
sr_two = df2.loc['둘']
print(sr_two, type(sr_two), sep='\n')

print("="*20)
df2['이름'].name = '브브걸'
print(df2)