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
sr_two = df2.loc['둘'] # 행 시리즈를 들고옴
print(sr_two, type(sr_two), sep='\n')

print("="*20)
df2['이름'].name = '브브걸' # 시리즈의 이름을 브브걸로 변경
print(df2) # 전체 데이터프레임에는 이름변경 안됨

print("🐱‍"*20)
print(df2.loc['넷']['생일'])
print(df2.loc['넷', '생일'])
# print(df2.iloc[3][2]) #FutureWarning: Series.__getitem__ treating keys as positions is deprecated. #FutureWarning: Series.__getitem__ treating keys as positions is deprecated.
print(df2.iloc[3, 2])

df2['키'] = [163, 165, 168, 166]
print(df2)
sr_vision = pd.Series([1.8,8.9,1.2], index=['셋', '하나', '넷'])
df2['시력'] = sr_vision
print(df2)

df2.insert(1, '꽃', ['장미', '백합', '튤립', '데이지']) # 열 추가
print(df2)

df2.loc['다섯'] = ['제남', '들꽃', 33, '1998.8.8', 177, 1.1] # 행 추가
print(df2)

# df2에 없는 칼럼은 새로 추가됨
new_data = {'이름':['리사', '제니'], '나이':[23, 22]}
new_df = pd.DataFrame(new_data, index=['블핑', '블핑']);
df2 = pd.concat([df2, new_df])
print(df2)

df2 = df2.drop(['키'], axis=1) # axis=1 : 열,
print(df2)
df2 = df2.drop(['셋'], axis=0) # axis=0 : 행,
print(df2)

df2 = df2.drop(['꽃', '시력'], axis=1) # 꽃, 시력 칼럼 삭제
print(df2)
df2 = df2.drop(['블핑', '하나']) # 블핑, 하나와 관련된 row 삭제 (중복도 포함)
print(df2)