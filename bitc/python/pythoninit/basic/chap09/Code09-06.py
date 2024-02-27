import bs4

webPage = open('C:/pjm/pythoninit/basic/chap09/sample03.html', encoding='utf-8').read()
bsObject = bs4.BeautifulSoup(webPage, 'html.parser')

tag_id = bsObject.find('div', {'id': 'myId1'})
print(tag_id)
print()

tag_class = bsObject.find('div', {'class': 'myClass1'})
print(tag_class)
print()

tag_class_all = bsObject.findAll('div', {'class': 'myClass1'})
print(tag_class_all)
print()

find_id_text = bsObject.find('div', {'id': 'myId1'})
print(find_id_text.text)

find_class_text = bsObject.find('div', {'class': 'myClass1'})
print(find_class_text.text)

print()

for item in tag_class_all:
    print(item.text)
    print(item.get_text())
    print(item.text.strip()) #공백제거
    print(item.get_text().strip()) #공백제거
