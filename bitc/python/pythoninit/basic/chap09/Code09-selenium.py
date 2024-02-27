import time

from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()

driver.get('https://sports.news.naver.com/index')
time.sleep(1)

titles = driver.find_elements(By.CSS_SELECTOR, 'strong.title')

for title in titles:
    print(title.text)

driver.quit()