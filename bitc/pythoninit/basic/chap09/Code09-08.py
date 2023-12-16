import bs4

webPage = open('C:/pjm/pythoninit/basic/chap09/sample03.html', encoding='utf-8').read()
bsObject = bs4.BeautifulSoup(webPage, 'html.parser')

a_list = bsObject.findAll('a')
for a_tag in a_list:
    print(a_tag['href'])