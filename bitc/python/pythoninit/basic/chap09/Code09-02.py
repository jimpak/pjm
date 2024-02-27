import urllib.request
import bs4

'''

 웹 크롤링 : 무분별하게 웹 정보를 추출 (중복 제거)
 웹 스크래핑 : 타겟을 정하고 추출 (중복 허용)

 웹 스크래핑 라이브러리
 1) BeautifulSoup : 복잡한 HTML문서를 태그, 탐색 가능한 문자열 또는 주석 등 
                    파이썬 객체 트리로 변환. 
                    HTML에서 데이터를 추출해야 하는 중소규모의 스크래핑 작업에 적합 
 2) Scrapy : 복잡한 스크래핑 작업을 처리할 수 있는 포괄적인 웹 크롤링 프레임워크.
             대규모이고 복잡한 웹스크래핑 작업에 가장 적합.
 3) Selenium : 웹페이지 이벤트 처리 등의 인간과 유사한 동작을 시뮬레이션해서
               비동기로 콘텐츠 로드되거나 사용자 상호작용에 응답하는 동적 웹 사이트에 적합

'''

# BeautifulSoup
nateUrl = "https://www.nate.com"
htmlObject = urllib.request.urlopen(nateUrl)
bsObject = bs4.BeautifulSoup(htmlObject, 'html.parser')
print(bsObject)