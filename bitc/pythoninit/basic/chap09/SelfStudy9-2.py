import bs4
import urllib.request

hanbitUrl = "https://www.hanbit.co.kr/"
htmlObject = urllib.request.urlopen(hanbitUrl)
webPage = htmlObject.read()
bsObject = bs4.BeautifulSoup(webPage, "html.parser")

tag = bsObject.find('ul', {'class': 'top_brand'})

print('## 한빛출판네트워크 메뉴 목록 ##')
li_list = tag.findAll('li')
for li in li_list:
    print(li.text, end=' ')