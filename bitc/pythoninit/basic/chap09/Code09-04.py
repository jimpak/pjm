import bs4

webPage = open('C:/pjm/pythoninit/basic/chap09/sample02.html', encoding='utf-8').read()
bsObject = bs4.BeautifulSoup(webPage, 'html.parser')
tag_div = bsObject.find('div')
print(tag_div)