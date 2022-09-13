# Chapter 2 : Meaningful Names

### Use Intention-Revealing Names

- 의도를 드러내는 이름을 짓는 것은 많은 시간이 드는 아주 어려운 일이다. 그러나 좋은 이름을 선택하면 결과적으로 훨씬 많은 시간을 아낄 수 있다.
- 의도를 드러내는 이름이란, 왜 존재하고 무엇을 하고 어떻게 사용되는지를 말해주는 이름이다.

```java
// example1
public List<int[]> getThem() {
	List<int[]> list1 = new ArrayList<int[]>();
	for (int[] x : theList)
		if (x[0] == 4)
			list1.add(x);
	return list1;
}

// example2
public List<int[]> getFlaggedCells() {
	List<int[]> flaggedCells = new ArrayList<int[]>();
	for (int [] cell: gameBoard)
		if (cell[STATUS_VALUE] == FLAGGED)
			flaggedCells.add(cell);
	return flaggedCells;
}
```

- Example 1은 단순하지만 코드 이름이 암시적이므로 이해하기 힘들다. 반면 example2는 여전히 단순하지만 이름이 더 명시적이어서 이해하기 쉽다.

### Avoid Disinformation

- 코드의 의미를 잘못 이해할 수 있는 단서를 남겨두지 말아야 한다.
    - *accountList*라는 이름은 실제로 자료구조가 List가 아니라면 사용하지 않는 것이 좋다. *accountList* 대신, *accountGroup*이나 *accounts*와 같은 이름을 사용하라.
- 차이를 구분하기 힘든 이름을 사용하지 말라.
    - XYZControllerForEfficientHandlingOfStrings와 XYZControllerForEfficientStorageOfStrings 사이의 차이는 알아보기 쉽지 않다.
- 비슷한 의미를 가지는 개념은 비슷하게 spelling하라.
    - 코드 자동완성의 기능을 제대로 활용하기 위해서는 비슷한 의미를 가지는 개념을 비슷한 스펠링을 가지도록 이름 지어야 한다.
    - 사용자가 해당 이름을 사용할 때마다 자동완성에 의해 추천된 이름 목록에서 적절한 이름을 선택할 수 있도록 이름 지어라.
    - 비슷한 스펠링을 가지더라도 차이는 분명해야 사용자가 적절한 이름을 선택할 수 있다.

### Make Meaningful Distinctions

- 이름이 다르다면, 의미 또한 달라야 한다. 따라서 숫자나 noise word를 더해서 변수 이름을 다르게 만드는 것은 좋지 않다.
- Number-series in Naming
    - a1, …, aN의 변수는 화자의 의도에 대한 어떠한 정보도 주지 않는다.
    
    ```java
    public static void copyChars(char a1[], char a2[]) {
    	for (int i = 0; i < a1.length; i++) {
    		a2[i] = a1[i];
    	}
    }
    ```
    
    - a1과 a2를 source와 destination으로 바꿈으로써 이름이 나타내는 개념들 사이의 차이를 부각할 수 있다.
- Noise words in Naming
    - *Product* 클래스와 *ProductInfo*, *ProductData* 클래스가 존재한다고 해보자. *ProductInfo*와 *ProductData*는 *Product*와 의미 차이가 크지 않다.
    - 이 경우 Info와 Data는 변수 이름의 noise words이다. 마찬가지로 관사 a, an, the 등도 사용을 지양해야 한다.
    - moneyAmount ⇒ money / customerInfo ⇒ customer / accountData ⇒ account / theMessage ⇒ message

### Use Pronounceable Names

- 개발팀 내에서의 원활한 소통과 코드의 가독성을 높이기 위해서는 발음이 가능한 이름을 사용하는 것이 좋다.
    - genymdhms ⇒ generationTimestamp
    - modymdhms ⇒ modificationTimestamp
    - pszqint ⇒ recordId

### Use Searchable Names

- 상수 대신 검색 가능한 이름을 사용하라.
    - 숫자 7보다 MAX_CLASSES_PER_STUDENT가 훨씬 검색하기 쉽다.
- 변수 이름 또한 검색 가능한 이름을 사용하라.
    - 변수 이름의 길이는 scope의 크기에 비례한다. Scope가 큰 범위에서 자주 사용되는 변수은 무조건 검색 가능하도록 이름 지어라.

### Avoid Encodings

- 변수 이름에 타입이나 범위에 대한 정보를 더하는 것은 이해를 어렵게 만든다.
- 인터페이스와 그 구현체에 이름을 붙여야 할 때는, 구현체에 encoding을 더하라.
    - Interface에 이름을 더하게 되면, 그 인터페이스를 다루는 사용자가 인터페이스를 다루고 있다는 사실을 알게 된다. 이는 사용자 입장에서 불필요한 정보이다.
    - Interface → ShapeFactory / Implementation → ShpaeFactoryImp, CShapeFactory

### Avoid Mental Mappings

- 코드의 독자가 이름을 다른 이름으로 해석할 필요가 없도록 이름 지어야 한다.
- 똑똑한 프로그래머 입장에서는 이러한 mental mapping이 자신의 지능을 보여줄 기회일 수 도 있지만, 이는 코드를 읽고 이해하는데 걸리는 시간을 늘린다.

### Class Names

- Class 이름은 명사 혹은 명사구여야 한다.
    - Customer, WikiPage, Account, AddressParser
    - Manager, Processor, Data, Info와 같은 이름을 클래스 이름으로 쓰는 것을 피해라. 클래스 이름은 동사여서는 안된다.

### Method Names

- Method 이름은 동사 혹은 동사구여야 한다.
    - postPayment, deletePage, save
- 각 Method의 종류에 따라 다음과 같은 단어를 이름에 포함해야 한다.
    - Accessors ⇒ get
    - Mutators ⇒ set
    - Predicates ⇒ is
- 생성자가 오버로딩 되었을 때, 인자를 묘사하는 정적 팩토리 메소드를 사용하자
    - “Example 1”이 인자를 묘사하고 있다는 점에서 더 낫다.
    
    ```java
    // Example 1
    Complex fulcrumPoint = Complex.FromRealNumber(23.0);
    
    // Example 2
    Complex fulcrumPoint = new Complex(23.0);
    ```
    
    - 대응되는 constructor를 private으로 만들어서 인자를 묘사하고 있는 메소드를 사용하도록 강제하는 것도 좋다.

### Don’t be cute

- 이름에 특정 문화권의 사람만이 이해할 수 있는 요소를 포함하지 말라.

### Pick One word per Concept

- 하나의 개념에 대해서는 하나의 단어만을 선택하라
    - 만약 Acessors method에 대해서 get, fetch, retrieve 등의 단어를 동시에 사용한다면, 어떤 클래스에 대해서 어떤 단어를 써야할지가 명확하지 않다.
- 이름이 같지 않다면, 다른 개념을 의미해야 한다.
    - DeviceManager와 ProtocolController의 본질적인 의미 차이는 무엇인가? 둘 사이에 의미 차이가 적다고 하더라도 이름이 다르다면 독자는 다른 의미로 받아들인다.
    - 만약 두 이름이 같은 개념을 의미한다면 일관적이게 한 쪽의 이름만을 사용하는 것이 좋다.

### Don’t Pun

- 두가지 목적을 위해 하나의 단어를 사용하는 것을 피하라

### Use Solution Domain Names

- 코드의 독자는 프로그래머이다. 따라서 코드에 포함된 CS 단어들은 코드 목표(해법)의 이해를 돕는다.
    - 경험 많은 프로그래머라면 AccountVisitor를 보고 Visitor Pattern을 떠올릴 것이다. 이처럼 solution domain name을 사용하는 것은 코드의 이해를 돕는다.

### Use Problem Domain Names

- Solution과 Problem 영역의 개념을 분리해라. Problem 영역에 대해서는 해당 영역 전문가에게 물을 수 있도록 problem 영역의 단어를 사용하라.

### Add Meaningful Context

- 이름이 맥락에 의존하고 있다면, 그 맥락을 접두사로 이름에 추가하라
    - firstName, lastName, street, houseNumber, city, state, zipcode라는 변수 이름을 모두 놓아 놓고 보면, 주소를 묘사하고 있다는 것을 알 수 있다.
    - 그러나 state라는 이름은 맥락에서 벗어나면 다른 의미를 가질 수 있다.
    - 이 경우에는 아래 예시와 같이 접두사를 통해 맥락을 드러내는 것이 좋다.
    - firstName ⇒ addrFisrtName / lastName ⇒ addrLastName / state ⇒ addrState

### Don’t Add Gratutious Context

- 짧은 이름이 긴 이름보다 좋다. 쓸데없는 맥락을 추가하지 말라.
    - accountAddress ⇒ Address
    - Address ⇒ PostalAddress, MACAddress ⇒ MAC, WebAddress ⇒ URI와 같은 식으로 context를 추가하지 않는 더 간결한 이름을 고려해보라.


# Chapter 3 : Functions

### Motivation

```java
public static String testableHtml( 
	PageData pageData,
	boolean includeSuiteSetup
) throws Exception {
	WikiPage wikiPage = pageData.getWikiPage(); 
	StringBuffer buffer = new StringBuffer(); 
	if (pageData.hasAttribute("Test")) {
		if (includeSuiteSetup) { 
			WikiPage suiteSetup = PageCrawlerImpl.getInheritedPage(SuiteResponder.SUITE_SETUP_NAME, wikiPage);
			if (suiteSetup != null) {
				WikiPagePath pagePath = suiteSetup.getPageCrawler().getFullPath(suiteSetup);
				String pagePathName = PathParser.render(pagePath); 
				buffer.append("!include -setup .")
							.append(pagePathName)
							.append("\n");
			} 
		}
		WikiPage setup = PageCrawlerImpl.getInheritedPage("SetUp", wikiPage);
		if (setup != null) { 
			WikiPagePath setupPath = wikiPage.getPageCrawler().getFullPath(setup); 
			String setupPathName = PathParser.render(setupPath); 
			buffer.append("!include -setup .")
						.append(setupPathName)
						.append("\n");
		} 
	}
	buffer.append(pageData.getContent()); 
	if (pageData.hasAttribute("Test")) {
		WikiPage teardown = PageCrawlerImpl.getInheritedPage("TearDown", wikiPage);
		if (teardown != null) { 
			WikiPagePath tearDownPath = wikiPage.getPageCrawler().getFullPath(teardown);
			String tearDownPathName = PathParser.render(tearDownPath); 
			buffer.append("\n")
						.append("!include -teardown .")
						.append(tearDownPathName)
						.append("\n");
		}
		if (includeSuiteSetup) { 
			WikiPage suiteTeardown =
				PageCrawlerImpl.getInheritedPage( 
					SuiteResponder.SUITE_TEARDOWN_NAME,
					wikiPage
				);
			if (suiteTeardown != null) {
				WikiPagePath pagePath = suiteTeardown.getPageCrawler().getFullPath (suiteTeardown);
				String pagePathName = PathParser.render(pagePath);
				buffer.append("!include -teardown .")
							.append(pagePathName) 
							.append("\n");
			} 
		}
	} 
	pageData.setContent(buffer.toString()); return pageData.getHtml();
}
```

```java
public static String renderPageWithSetupsAndTeardowns(
 PageData pageData, boolean isSuite
) throws Exception {
	boolean isTestPage = pageData.hasAttribute("Test"); 
	if (isTestPage) {
		WikiPage testPage = pageData.getWikiPage(); 
		StringBuffer newPageContent = new StringBuffer(); 
		includeSetupPages(testPage, newPageContent, isSuite); 
		newPageContent.append(pageData.getContent()); 
		includeTeardownPages(testPage, newPageContent, isSuite); 
		pageData.setContent(newPageContent.toString());
	}
	return pageData.getHtml(); 
}
```

  위의 두 예제는 같은 작업을 하는 코드이다. 그러나 아래의 코드가 훨씬 이해하기 쉽다는 사실을 알 수 있다. 이처럼 함수 코드의 작성이 간결하고 이해하기 쉬울수록 생산성이 증가한다. 함수를 간결하게 작성하기 위해서는 함수 코드의 길이가 작아야만 하고, 추상화의 수준을 정확히 정해야 한다. 여러 레벨의 추상화를 동시에 다루게 되면 함수의 코드가 점점 복잡해진다. 이 단원에서는 어떻게 하면 이해하기 쉽고, 의도가 잘 드러나는 함수 코드를 작성할 수 있는지를 배운다.

### Small!

- 읽고 이해하기 쉬운 함수를 작성하기 위해서는, 함수 코드의 길이가 작아야 한다.
    - If, else, while문의 블럭 안에 한두 줄만이 포함될 정도로 짧아야 한다.
    - Nested structure의 indent level이 두 단계를 넘어가지 않도록 하라.
    - 그 이상의 nested structure가 필요하다면, nested block을 적절한 이름을 가진 하나의 함수로 만들어라.

### Do One Thing

- 함수는 한 가지 작업을 담당해야 한다.
    - 이 때 한 가지 작업은 한 줄의 코드가 아니라, 함수에서 처리하는 모든 작업이 같은 수준의 추상화 위에 놓여 있어야 한다는 의미이다.
    - 즉, 함수를 작성하는 이유는 커다란 개념을 바로 아래 수준의 추상화된 개념으로 분해하는 것이다.
    - 만약 어떤 함수에서 restatement가 아닌 형태로 여러 줄의 코드를 합칠 수 있다면, 그 함수는 한 가지 작업을 담당하고 있는 것이 아니다.
    - 함수에서 코드들을 section으로 나누기보다는, 각 section을 하나의 함수로 만들어라.

### One Level of Abstraction per Function

- 함수가 한 가지 작업을 하기 위해서는, 함수 안의 statement들이 같은 수준의 추상화에 놓여 있어야 한다.
    - 여러 수준의 추상화를 하나의 함수에 섞어 놓으면, 코드를 읽을 때 혼란스러움을 느끼게 된다. 또한 이런 상황에서는 코드의 독자가 각 expression이 세부사항인지 추상적 개념인지를 구분해가며 읽어야만 한다.
- Reading Code from Top to Bottom : The Stepdown Rule
    - 추가 작성 필요

### Switch Statements

- Switch문은 다형성을 활용하여 제거한다.
    - 아래 함수는 type이 추가되었을 때 수정되어야 한다는 점, 한 가지보다 더 많은 작업을 하고 있다는 점, SRP와 OCP를 위반하고 있다는 점에서 문제가 있다.
    
    ```java
    public Money calculatePay(Employee e)
    throws InvalidEmployeeType {
    	switch (e.type) {
    		case COMMISSIONED:
    			return caculateComissionedPay(e);
    		case HOURLY:
    			return caculateHourlyPay(e);
    		case SALARIED:
    			return caculateSalariedPay(e);
    		default:
    			throw new InvalidEmployeeType(e.type);
    	}
    }		
    ```
    
    - calculatePay를 위와 같은 구조로 코딩하면, isPayday(Employee e, Date date), deliverPay(Employee e, Money pay)와 같은 함수도 마찬가지로 같은 구조를 가질 것이다.
    - Abstract factory 패턴을 사용하여 객체 생성 시에만 switch문을 사용하도록 할 수 있다.
    
    ```java
    public abstract class Employee {
    	public abstract boolean isPayday();
    	public abstract Money calculatePay();
    	public abstract void deliverPay (Money pay);
    }
    
    public interface EmployeeFactory {
    	public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType;
    }
    
    public class EmployeeFactoryImpl implements EmployeeFactory {
    	public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType {
    		switch (r.type) {
    			case COMMISIONED:
    				return new CommisionedEmployee(r);
    			case HOURLY:
    				return new HourlyEmployee(r);
    			case SALARIED:
    				return new HourlyEmployee(r);
    			default:
    				throw new InvalidEmployeeType(r.type);
    		}
    	}
    }
    ```
    

### Use Descriptive Names

- 길이가 길어지더라도 descriptive한 이름을 사용해라.
    - testableHtml ⇒ SetupTeardownIncluder.render
    - 맥락이나 목적어에 대한 설명이 들어간 이름은 함수가 어떤 역할을 하는지 예상하기 쉽게 만든다.
- 이름들의 일관성을 유지하라
    - 여러 함수 이름들에서 같은 구절, 명사, 동사를 사용해라
    - includeSetupAndTeardownPages, includeSetupPages, includeSuiteSetupPage 등 같은 동사를 사용한 함수들은 그 이름에서 차이를 알기 쉽고, 역할을 쉽게 예상할 수 있다.

### Function Arguments

- 인자의 개수가 세 개가 넘어가는 상황을 피해야 한다.
    - 함수 인자의 개수가 적을 수록 코드를 이해하기 쉬워진다.
    - 인자는 강력한 개념적 힘을 가지고 있다. 즉 코드의 독자는 인자를 보고 함수의 역할을 특정한다.
    - 만약 StringBuffer 등이 객체 인스턴스 변수가 아니라 인자로 계속해서 전달된다면, 독자는 함수를 읽을 때마다 그 인자의 의미를 해석해야 한다.
- 함수의 인자 개수가 적을 수록 테스트가 쉬워진다.
    - 함수의 인자 개수가 적을 수록 가능한 값의 조합 개수가 적어지고, 따라서 테스트가 쉬워진다.
- Output arguments의 사용을 자제해라.
    - Output arguments는 이해하기 힘들다. 코드의 독자는 함수에 인자가 정보로서 주어진다고 생각하기 때문에, output arguments를 이해하기 위해서는 시간이 필요하다.
    
    ### Common Monadic Forms
    
    - 단일 인자 함수는 주로 인자에 대해 질문, 인자를 변형하여 반환하는 함수이다.
        - boolean fileExists(”MyFile”) : 파일이 존재하는지 질문한다.
        - InputStream fileOpen(”MyFile”) : 문자열을 InputStream으로 변환한다.
    - Event 또한 단일 인자 함수로 나타낼 수 있다.
        - 이 경우 인자는 시스템의 상태를 나타내는데 사용된다.
        - void passwordAttempFailedNtimes(int attempts)
    - 이외의 상황에서는 단일 인자 함수의 사용을 피해라.
        - includeSetupPageInto(StringBuffer pageText) 대신 includeSetupPage()가 더 낫다.
    
    ### Flag Arguments
    
    - Boolean을 flag arguments로서 함수에 넘겨주는 것은 좋지 않다. 그것은 함수의 signature를 복잡하게 만들고 함수가 여러가지 작업을 하도록 만든다.
    
    ### Dyadic Functions
    
    - 두 개의 인자를 가진 함수는 Moandic function보다 이해하기에 힘들다.
        - writeField(outputStream, name) ⇒ writeField(name)
    - 두 개의 인자를 가진 함수를 작성할 때는 인자의 순서를 잘 고려해야 한다.
        - 아래 예제는 인자 사이에 자연스러운 순서가 존재한다.
        
        ```java
        Point p = new Point(0, 0);
        ```
        
        - 아래 예제는 인자 사이에 자연스러운 순서가 존재하지 않는다.
        
        ```java
        assertEquals(expected, actual)
        ```
        
        - 순서가 존재하지 않는 경우, 인자의 순서는 convention이 된다. 이 경우 monadic function으로 변경 가능한지 고려하는 것이 좋다.
    
    ### Argument Objects
    
    - 여러 인자를 하나의 객체로 묶어라.
        - 함수가 세 개 이상의 인자를 가진다면, 인자 중 몇몇을 묶어서 하나의 클래스 개념을 구성할 수 있을 가능성이 높다.
        
        ```java
        Circle makeCircle(double x, double y, double radius);
        Circle makeCircle(Point center, double radius);
        ```
        
    
    ### Argument Lists
    
    - 인자의 개수가 달라질 수 있는 함수에서 인자들은 실제로는 하나의 List를 의미한다.
        - String.format(”%s worked %.2f hours.”, name, hours);
        - 위의 예제에서 names와 hours를 묶어서 하나의 List로 생각할 수 있다. 즉 위 함수는 본질적으로는 dyadic이다.
    
    ### Verbs and Keywords
    
    - 좋은 함수 이름을 고르는 것은 함수의 의도와 인자의 의도, 순서를 잘 설명하는 이름을 찾는 것이다.
    - 모나드 함수의 경우, 함수와 인자는 잘 맞는 verb/noun 쌍을 이루어야 한다.
        - write(name) is good name, writeField(name) is better name.
        - write(name): name이 쓰여진다는 사실을 전달한다.
        - writeField(name): name이 쓰여진다는 사실에 더해서 name이 field라는 사실 또한 전달한다.
    - 인자의 이름을 함수의 이름에 encoding하여 인자의 순서 문제를 해결하라.
        - assertExpectedEqualsActual(expected, actual)

### Have No Side Effects

- Side Effect가 존재하면, 함수는 한 가지 일만을 하지 않는다.
    - 특히 side effect가 이름에서 드러나지 않는다면, 함수의 작업은 숨겨진 것이 된다.
    - Side effect는 temporal coupling을 생성하여 특정 함수가 불리는 시점을 한정할 수 있다.
    - checkPassword ⇒ checkPasswordAndInitializeSession로 바꾸면 함수가 한가지 이상의 작업을 하지만 이름에서 side effect를 드러낼 수 있다.
    
    ### Output Arguments
    
    - appendFooter(StringBuffer report)
    - report.appendFooter()

### Command Query Separation

- 함수는 무언가를 하거나, 주어진 질문에 답한다. 그러나 둘을 동시에 해서는 안된다.
- Command와 query의 의미를 분리해서 구별할 수 있는 이름을 사용해야 한다.
    - 아래 예제에서 set은 모호한 의미를 가지고 있다.
    
    ```java
    if (set("username", "unclebob")) ...
    ```
    
    - 이 예제에서 set은 adjective처럼 느껴진다. 함수 set의 의미가 command인지 query인지 명확하게 드러나지 않아서이다.
    - 다음과 같이 query와 command를 분리하는 것이 좋다.
    
    ```java
    if (attributeExists("username")) {
    	setAttribute("username", "unclebob");
    	...
    }
    ```
    

### Prefer Exceptions to Returning Error Codes

- Error code를 함수 반환값으로 반환하는 것은 좋지 않다.
    - if nested structure를 요구하기 때문이다.
- Error code는 exception으로 반환해라.
    
    ### Extract Try/Catch Blocks
    
    - Try/catch 블럭을 하나의 함수로 작성하라.
        - 복잡한 try, catch 블럭은 nested structre를 요구할 수 있다. 따라서 블럭의 내용을 하나의 함수로 묶는 것이 코드를 이해하기에 쉽다.

### Don’t Repeat Yourself

- Duplication을 제거하기 위해 노력해라.

### Structured Programming

- 다익스트라는 모든 함수와 블럭이 하나의 entry와 exit을 가져야 한다고 주장했다.
    - break, continue, goto문은 함수나 loop의 exit entry를 복잡하게 만든다.
- 함수 안에는 오로지 한 개의 return문이 존재하도록 하자.
- Loop문에는 break, continue 등을 사용하지 않도록 하자.
    - 단순한 함수에서는 single-exit rule을 지키지 않는 것이 더 표현력이 좋을 수 도 있다.

---

### Questions

- Switch statement에서 타입에 따라 다른 작업을 처리해야 하는 경우는 다형성으로 처리가 가능한가?