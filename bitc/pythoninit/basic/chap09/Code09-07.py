import bs4

webPage = open('C:/pjm/pythoninit/basic/chap09/sample03.html', encoding='utf-8').read()
bsObject = bs4.BeautifulSoup(webPage, 'html.parser')

ul_value = bsObject.find('ul', {'class': 'myClass2'})
print(ul_value)
print()
li_list = bsObject.findAll('li', {'class': 'myClass3'})
print(li_list)