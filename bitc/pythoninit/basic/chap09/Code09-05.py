import bs4

webPage = open('C:/pjm/pythoninit/basic/chap09/sample02.html', encoding='utf-8').read()
bsObject = bs4.BeautifulSoup(webPage, 'html.parser')

tag_ul = bsObject.find('ul')
print(tag_ul)
print()

tag_li = bsObject.find('li')
print(tag_li)
print()

tag_ul_all = bsObject.findAll('li')
print(tag_ul_all)
print()