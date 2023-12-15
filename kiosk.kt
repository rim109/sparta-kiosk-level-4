package kiosk

import kotlin.system.exitProcess

fun main() {
    val kiosk = Kiosk()
    kiosk.runKiosk()

    var menuPan = kiosk.menuKiosk()
    val mainBurger = Hamburger()
    val mainIce = Ice()
    val mainDr = Drinks()
    val mainBe = Beer()


    while (true) {

        when (menuPan) {
            1 -> menuPan = mainBurger.choose(kiosk.burgerMenu)
            2 -> menuPan = mainIce.choose(kiosk.iceMenu)
            3 -> menuPan = mainDr.choose(kiosk.drinkMenu)
            4 -> menuPan = mainBe.choose(kiosk.beerMenu)
            9 -> {
                println("\u001B[31m잘못된 입력값입니다. 처음부터 다시 입력해주세요!\u001B[0m")
                menuPan = kiosk.menuKiosk()
            }

            0 -> {
                println("\u001B[31m프로그램이 종료되었습니다.\u001B[0m")
                exitProcess(0)
            }

            else -> {
                println("\u001B[31m잘못된 번호를 입력하셨어요. 다시 입력해주세요!\u001B[0m")
                menuPan = kiosk.menuKiosk()
            }
        }
        if (menuPan == 0) {
            menuPan = kiosk.menuKiosk()
        }
        println(menuPan)
    }

}

open class Kiosk {
    val burgerMenu = ArrayList<AbstractMenu>()
    val iceMenu = ArrayList<AbstractMenu>()
    val drinkMenu = ArrayList<AbstractMenu>()
    val beerMenu = ArrayList<AbstractMenu>()

    fun runKiosk() {
        initKiosk()
    }

    fun menuKiosk(): Int {
        try {
            println("\u001B[35m오신 것을 환영합니다!!\u001B[35m")
            println("\u001B[32m아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\u001B[0m")
            println("\u001B[32m[ Menu ]\u001B[0m")
            println(
                "1. Burgers         | 앵거스 비프 통살을 다져만든 버거\n" +
                        "2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림\n" +
                        "3. Drinks          | 매장에서 직접 만드는 음료\n" +
                        "4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주\n" +
                        "0. exit            | 프로그램 종료\n"
            )
            return readln().toInt()
        } catch (e: NumberFormatException) {
            return 9
        }
    }


    fun initKiosk() {
        burgerMenu.add(Hamburger(1, "ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"))
        burgerMenu.add(Hamburger(2, "SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"))
        burgerMenu.add(Hamburger(3, "Shroom Burger", 9400, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"))
        burgerMenu.add(Hamburger(4, "Cheeseburger", 9400, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"))
        burgerMenu.add(Hamburger(5, "Cheeseburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"))
        burgerMenu.add(Hamburger(0, "뒤로가기", 0, "다시 메인 메뉴로 이동한다"))

        iceMenu.add(Ice(1, "chocolate", 4900, "초콜릿 맛 아이스크림"))
        iceMenu.add(Ice(2, "vanilla", 4900, "바닐라 맛 아이스크림"))
        iceMenu.add(Ice(3, "strawberry", 5400, "딸기 맛 아이스크림"))
        iceMenu.add(Ice(4, "rainbow", 6200, "레인보우 맛 아이스크림"))
        iceMenu.add(Ice(5, "blueberry", 4000, "블루베리 맛 아이스크림"))
        iceMenu.add(Ice(0, "뒤로가기", 0, "다시 메인 메뉴로 이동한다"))

        drinkMenu.add(Drinks(1, "orange juice", 3900, "상큼한 오렌지 주스"))
        drinkMenu.add(Drinks(2, "ice-tea", 3900, "달콤한 아이스 티"))
        drinkMenu.add(Drinks(3, "tea", 2800, "따뜻한 한잔의 티"))
        drinkMenu.add(Drinks(4, "cola", 3500, "시원함을 느낄 수 있는 콜라"))
        drinkMenu.add(Drinks(5, "coffee", 4800, "온몸이 짜릿해지는 커피 한잔"))
        drinkMenu.add(Drinks(0, "뒤로가기", 0, "다시 메인 메뉴로 이동한다"))

        beerMenu.add(Beer(1, "Pale Ale ", 4900, "풍부한 향의 에일"))
        beerMenu.add(Beer(2, "Larger", 4900, "깔끔함의 극치 라거"))
        beerMenu.add(Beer(3, "Dark Beer", 4800, "매력의 소유자 흑맥주"))
        beerMenu.add(Beer(4, "Cass", 3500, "한국의 대표적인 맥주"))
        beerMenu.add(Beer(5, "Tsingtao", 3800, "중국의 칭따오 맥주"))
        beerMenu.add(Beer(0, "뒤로가기", 0, "다시 메인 메뉴로 이동한다"))
    }
}

abstract class AbstractMenu {
    abstract fun choose(burgerMenus: ArrayList<AbstractMenu>): Int
    var Number = 0
    var Name = ""
    var Price = 0
    var Content = ""
    val bagList = arrayListOf<String>()

}

class Hamburger() : AbstractMenu() {
    constructor(Number: Int, Name: String, Price: Int, Content: String) : this() {
        super.Number = Number
        super.Name = Name
        super.Price = Price
        super.Content = Content
    }
    
    override fun choose(burgerMenus: ArrayList<AbstractMenu>): Int {
        extracted(burgerMenus)
        return 0
    }

    private fun extracted(burgerMenus: ArrayList<AbstractMenu>) {
        while (true) {
            try {
                println("\u001B[32m 햄버거의 메뉴를 골라 숫자를 입력해주세요\u001B[0m")
                for (b in burgerMenus) {
                    println(b.Number)
                    println(b.Name)
                    println(b.Price)
                    println("-------------------------------------------")
                    println(b.Content)
                    println("-------------------------------------------")
                }

                var Number = readln().toInt()

                if (Number == 0) {
                    println("뒤로 가기를 선택하셨습니다")
                    break
                } else if (Number in (1..5)) {
                    println("${Number} | ${burgerMenus[Number - 1].Name} |${burgerMenus[Number - 1].Price}원 | ${burgerMenus[Number - 1].Content} | 위 메뉴를 장바구니에 추가하시겠습니까?")
                    println("네 , 아니오")
                    var answer = readln().toString()
                    if (answer == "네") {
                        println("\u001B[32m[ Orders ]\u001B[0m")
                        var bag = "${burgerMenus[Number - 1].Name} | ${burgerMenus[Number - 1].Price}"
                        bagList.add(bag)
                        // 장바구니에 담아줌
                        println("${Number} | ${burgerMenus[Number - 1].Name} | ${burgerMenus[Number - 1].Price}원 | ${burgerMenus[Number - 1].Content}| (이/가) 장바구니에 추가되었습니다.")
                        println("----------------------------------------------------------------------------------------------")
                        println("\u001B[32m[ Total ]\u001B[0m ${burgerMenus[Number - 1].Price}원")

                        println("원하시는 번호를 입력해주세요!")
                        println("1. 지불하기 2. 장바구니 취소")
                        var select = readln().toInt()
                        var bags = "${burgerMenus[Number - 1].Name} | ${burgerMenus[Number - 1].Price}"
                        if (select == 2) {
                            bagList.remove(bags)
                            println("취소되었습니다. 감사합니다.")
                            exitProcess(0)
                        } else if (select == 1) {
                            println("지불하기를 선택하셨습니다")
                        } else {
                            println("\u001B[31m잘못된 번호를 입력하셨어요. 처음부터 다시 선택해주세요!\u001B[0m")
                            break
                        }

                        println("지불할 금액을 작성하세요")
                        var myPrice = readln().toInt()
                        myPrice -= burgerMenus[Number - 1].Price
                        var balance = burgerMenus[Number - 1].Price
                        if (myPrice >= Price) {
                            println("\u001B[32m[ Total ]\u001B[0m 거스름돈은 ${myPrice}원 입니다. 감사합니다")
                        } else {
                            println("총 가격은 ${balance}원 이므로 ${myPrice}원이 부족하여 작성하신 금액으로는 계산할 수 없습니다. 다시 시도해주세요! 감사합니다")
                            exitProcess(0)
                        }

                        println("원하시는 번호를 입력해주세요!")
                        println("1. 바로 주문하기   2. 메뉴판 다시 보기")
                        var choice = readln().toInt()
                        if (choice == 1) {
                            println("주문되셨습니다. 감사합니다. 다음에 또 와주세요")
                            exitProcess(0)
                        } else 0
                    } else if (answer == "아니오") {
                        println("다른 메뉴를 선택해주세요.")
                    } else println("\u001B[31m잘못된 입력값을 입력하셨어요. 다시 입력해주세요!\u001B[0m")

                } else println("\u001B[31m잘못된 번호를 입력하셨어요. 다시 입력해주세요!\u001B[0m")
            } catch (e: NumberFormatException) {
                return println("\u001B[31m잘못된 입력값입니다. 처음부터 다시 입력해주세요\u001B[0m")
            }
        }
    }
}

open class Ice() : AbstractMenu() {
    constructor(Number: Int, Name: String, Price: Int, Content: String) : this() {
        super.Number = Number
        super.Name = Name
        super.Price = Price
        super.Content = Content
    }

    override fun choose(iceMenus: ArrayList<AbstractMenu>): Int {
        while (true) {
            try {
                println("\u001B[32m 아이스크림의 메뉴를 골라 숫자를 입력해주세요\u001B[0m")
                for (i in iceMenus) {
                    println(i.Number)
                    println(i.Name)
                    println(i.Price)
                    println("-------------------------------------------")
                    println(i.Content)
                    println("-------------------------------------------")
                }

                var Number = readln().toInt()

                if (Number == 0) {
                    println("뒤로 가기를 선택하셨습니다")
                    break
                } else if (Number in (1..5)) {
                    println("${Number} | ${iceMenus[Number - 1].Name} | ${iceMenus[Number - 1].Price}원 | ${iceMenus[Number - 1].Content} | 위 메뉴를 장바구니에 추가하시겠습니까?")
                    println("네 , 아니오")
                    var answer = readln().toString()
                    if (answer == "네") {
                        println("\u001B[32m[ Orders ]\u001B[0m")
                        var bag = "${iceMenus[Number - 1].Name} | ${iceMenus[Number - 1].Price}"
                        bagList.add(bag)
                        println("${Number} | ${iceMenus[Number - 1].Name} | ${iceMenus[Number - 1].Price}원 | ${iceMenus[Number - 1].Content} |(이/가) 장바구니에 추가되었습니다.")
                        println("----------------------------------------------------------------------------------------------")
                        println("\u001B[32m[ Total ]\u001B[0m ${iceMenus[Number - 1].Price}원")

                        println("원하시는 번호를 입력해주세요!")
                        println("1. 지불하기 2. 장바구니 취소")
                        var select = readln().toInt()
                        var bags = "${iceMenus[Number - 1].Name} | ${iceMenus[Number - 1].Price}"
                        if (select == 2) {
                            bagList.remove(bags)
                            println("취소되었습니다. 감사합니다.")
                            exitProcess(0)
                        } else if (select == 1) {
                            println("지불하기를 선택하셨습니다")
                        } else {
                            println("\u001B[31m잘못된 번호를 입력하셨어요. 처음부터 다시 선택해주세요!\u001B[0m")
                            break
                        }

                        println("지불할 금액을 작성하세요")
                        var myPrice = readln().toInt()
                        myPrice -= iceMenus[Number - 1].Price
                        var balance = iceMenus[Number - 1].Price

                        if (myPrice >= Price) {
                            println("\u001B[32m[ Total ]\u001B[0m 거스름돈은 ${myPrice}원 입니다. 감사합니다")
                        } else {
                            println("총 가격은 ${balance}원 이므로 ${myPrice}원이 부족하여 작성하신 금액으로는 계산할 수 없습니다. 다시 시도해주세요! 감사합니다")
                            exitProcess(0)
                        }

                        println("원하시는 번호를 입력해주세요!")
                        println("1. 바로 주문하기   2. 메뉴판 다시 보기")
                        var choice = readln().toInt()
                        if (choice == 1) {
                            println("주문되셨습니다. 감사합니다. 다음에 또 와주세요")
                            exitProcess(0)
                        } else 0
                    } else if (answer == "아니오") {
                        println("다른 메뉴를 선택해주세요.")
                    } else println("\u001B[31m잘못된 입력값을 입력하셨어요. 다시 입력해주세요!\u001B[0m")

                } else println("\u001B[31m잘못된 번호를 입력하셨어요. 다시 입력해주세요!\u001B[0m")
            } catch (e: NumberFormatException) {
                return 9
            }
        }
        return 0
    }
}

open class Drinks() : AbstractMenu() {
    constructor(Number: Int, Name: String, Price: Int, Content: String) : this() {
        super.Number = Number
        super.Name = Name
        super.Price = Price
        super.Content = Content
    }

    override fun choose(drinkMenus: ArrayList<AbstractMenu>): Int {
        while (true) {
            try {
                println("\u001B[32m 마실 음료의 메뉴를 골라 숫자를 입력해주세요\u001B[0m")
                for (d in drinkMenus) {
                    println(d.Number)
                    println(d.Name)
                    println(d.Price)
                    println("-------------------------------------------")
                    println(d.Content)
                    println("-------------------------------------------")
                }
                var Number = readln().toInt()

                if (Number == 0) {
                    println("뒤로 가기를 선택하셨습니다")
                    break
                } else if (Number in (1..5)) {
                    println("${Number} | ${drinkMenus[Number - 1].Name} | ${drinkMenus[Number - 1].Price}원 | ${drinkMenus[Number - 1].Content} | 위 메뉴를 장바구니에 추가하시겠습니까?")
                    println("네 , 아니오")
                    var answer = readln().toString()
                    if (answer == "네") {
                        println("\u001B[32m[ Orders ]\u001B[0m")
                        var bag = "${drinkMenus[Number - 1].Name} | ${drinkMenus[Number - 1].Price}"
                        bagList.add(bag)
                        println("${Number} | ${drinkMenus[Number - 1].Name} | ${drinkMenus[Number - 1].Price}원 | ${drinkMenus[Number - 1].Content} |(이/가) 장바구니에 추가되었습니다.")
                        println("----------------------------------------------------------------------------------------------")
                        println("\u001B[32m[ Total ]\u001B[0m ${drinkMenus[Number - 1].Price}원")

                        println("원하시는 번호를 입력해주세요!")
                        println("1. 지불하기 2. 장바구니 취소")
                        var select = readln().toInt()
                        var bags = "${drinkMenus[Number - 1].Name} | ${drinkMenus[Number - 1].Price}"

                        if (select == 2) {
                            bagList.remove(bags)
                            println("취소되었습니다. 감사합니다.")
                            exitProcess(0)
                        } else if (select == 1) {
                            println("지불하기를 선택하셨습니다")
                        } else {
                            println("\u001B[31m잘못된 번호를 입력하셨어요. 처음부터 다시 선택해주세요!\u001B[0m")
                            break
                        }

                        println("지불할 금액을 작성하세요")
                        var myPrice = readln().toInt()
                        myPrice -= drinkMenus[Number - 1].Price
                        var balance = drinkMenus[Number - 1].Price

                        if (myPrice >= Price) {
                            println("\u001B[32m[ Total ]\u001B[0m 거스름돈은 ${myPrice}원 입니다. 감사합니다")
                        } else {
                            println("총 가격은 ${balance}원 이므로 ${myPrice}원이 부족하여 작성하신 금액으로는 계산할 수 없습니다. 다시 시도해주세요! 감사합니다")
                            exitProcess(0)
                        }

                        println("원하시는 번호를 입력해주세요!")
                        println("1. 바로 주문하기   2. 메뉴판 다시 보기")
                        var choice = readln().toInt()
                        if (choice == 1) {
                            println("주문되셨습니다. 감사합니다. 다음에 또 와주세요")
                            exitProcess(0)
                        } else 0
                    } else if (answer == "아니오") {
                        println("다른 메뉴를 선택해주세요.")
                    } else println("\u001B[31m잘못된 입력값을 입력하셨어요. 다시 입력해주세요!\u001B[0m")

                } else println("\u001B[31m잘못된 번호를 입력하셨어요. 다시 입력해주세요!\u001B[0m")
            } catch (e: NumberFormatException) {
                return 9
            }
        }
        return 0
    }
}

class Beer() : AbstractMenu() {

    constructor(Number: Int, Name: String, Price: Int, Content: String) : this() {
        super.Number = Number
        super.Name = Name
        super.Price = Price
        super.Content = Content
    }

    override fun choose(beerMenus: ArrayList<AbstractMenu>): Int {
        while (true) {
            try {
                println("\u001B[32m맥주의 메뉴를 골라 숫자를 입력해주세요\u001B[0m")
                for (e in beerMenus) {
                    println(e.Number)
                    println(e.Name)
                    println(e.Price)
                    println("-------------------------------------------")
                    println(e.Content)
                    println("-------------------------------------------")
                }
                var Number = readln().toInt()

                if (Number == 0) {
                    println("뒤로 가기를 선택하셨습니다")
                    break
                } else if (Number in (1..5)) {
                    println("${Number} | ${beerMenus[Number - 1].Name} | ${beerMenus[Number - 1].Price}원 | ${beerMenus[Number - 1].Content} | 위 메뉴를 장바구니에 추가하시겠습니까?")
                    println("네 , 아니오")
                    var answer = readln().toString()
                    if (answer == "네") {
                        println("\u001B[32m[ Orders ]\u001B[0m")
                        var bag = "${beerMenus[Number - 1].Name} | ${beerMenus[Number - 1].Price}"
                        bagList.add(bag)
                        println("${Number} | ${beerMenus[Number - 1].Name} | ${beerMenus[Number - 1].Price}원 | ${beerMenus[Number - 1].Content}|(이/가) 장바구니에 추가되었습니다.")
                        println("----------------------------------------------------------------------------------------------")
                        println("\u001B[32m[ Total ]\u001B[0m 가격: ${beerMenus[Number - 1].Price}원")

                        println("원하시는 번호를 입력해주세요!")
                        println("1. 지불하기 2. 장바구니 취소")
                        var select = readln().toInt()
                        var bags = "${beerMenus[Number - 1].Name} | ${beerMenus[Number - 1].Price}"
                        if (select == 2) {
                            bagList.remove(bags)
                            println("취소되었습니다. 감사합니다.")
                            exitProcess(0)
                        } else if (select == 1) {
                            println("지불하기를 선택하셨습니다")
                        } else {
                            println("\u001B[31m잘못된 번호를 입력하셨어요. 처음부터 다시 선택해주세요!\u001B[0m")
                            break
                        }

                        println("지불할 금액을 작성하세요")
                        var myPrice = readln().toInt()
                        myPrice -= beerMenus[Number - 1].Price
                        var balance = beerMenus[Number - 1].Price

                        if (myPrice >= Price) {
                            println("\u001B[32m[ Total ]\u001B[0m 거스름돈은 ${myPrice}원 입니다. 감사합니다")
                        } else {
                            println("총 가격은 ${balance}원 이므로 ${myPrice}원이 부족하여 작성하신 금액으로는 계산할 수 없습니다. 다시 시도해주세요! 감사합니다")
                            exitProcess(0)
                        }

                        println("원하시는 번호를 입력해주세요!")
                        println("1. 바로 주문하기   2. 메뉴판 다시 보기")
                        var choice = readln().toInt()
                        if (choice == 1) {
                            println("주문되셨습니다. 감사합니다. 다음에 또 와주세요")
                            exitProcess(0)
                        } else 0
                    } else if (answer == "아니오") {
                        println("다른 메뉴를 선택해주세요.")
                    } else println("\u001B[31m잘못된 입력값을 입력하셨어요. 다시 입력해주세요!\u001B[0m")


                } else println("\u001B[31m잘못된 번호를 입력하셨어요. 다시 입력해주세요!\u001B[0m")
            } catch (e: NumberFormatException) {
                return 9
            }
        }
        return 0
    }
}
