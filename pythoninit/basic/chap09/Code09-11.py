import bs4
import urllib.request

nateUrl = "https://www.nate.com"
htmlObject = urllib.request.urlopen(nateUrl)
webPage = htmlObject.read()
bsObject = bs4.BeautifulSoup(webPage, "html.parser")

tag = bsObject.find('div', {'class': 'area_gnb'})

print('## 네이트 뉴스의 메뉴 목록 ##')
li_list = tag.findAll('li')
for li in li_list:
    print(li.text, end=' ')