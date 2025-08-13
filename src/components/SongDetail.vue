<template>
    <section class="container row-g3"
        style="background-color: #f2f1ff; max-width: 100%; margin-top: 0; padding-top: 0;">
        <div class="row">
            <aside class="col-sm-4 p-5 rounded-3"
                style="background-color: #3f3d56; margin-top: 50px; margin-bottom: 50px;">

                <!-- Tabs -->
                <ul class="nav nav-tabs" id="favoriteTabs" role="tablist">
                    <li class="nav-item" role="presentation">
                        <button class="nav-link active" id="songs-tab" data-bs-toggle="tab" data-bs-target="#songs"
                            type="button" role="tab" aria-controls="songs" aria-selected="true">
                            Bài hát yêu thích
                        </button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="artists-tab" data-bs-toggle="tab" data-bs-target="#artists"
                            type="button" role="tab" aria-controls="artists" aria-selected="false">
                            Nghệ sĩ yêu thích
                        </button>
                    </li>
                </ul>

                <!-- Tab Content -->
                <div class="tab-content mt-3" id="favoriteTabsContent">

                    <!-- Tab 1: Bài hát yêu thích -->
                    <div class="tab-pane fade show active" id="songs" role="tabpanel" aria-labelledby="songs-tab">
                        <ul class="list-group">
                            <li v-for="song in favoriteSongs" :key="song.id"
                                class="list-group-item d-flex align-items-center justify-content-between">
                                <div class="d-flex align-items-center gap-3">
                                    <img :src="song.image" alt="" style="width: 75px; height: 75px; object-fit: cover;"
                                        class="rounded-circle" />
                                    <span>{{ song.title }}</span>
                                </div>
                                <div class="d-flex gap-2">
                                    <button class="btn rounded-circle pink-button" style="width: 40px; height: 40px;">
                                        <i class="bi bi-play-fill"></i>
                                    </button>
                                    <button @click="favoritesStore.removeFavorite(song)" class="btn rounded-circle pink-button" style="width: 40px; height: 40px;">
                                        <i class="bi bi-dash"></i>
                                    </button>
                                </div>
                            </li>
                            <li v-if="favoriteSongs.length === 0" class="list-group-item text-center text-muted">Chưa có
                                bài hát yêu thích</li>
                        </ul>
                    </div>

                    <!-- Tab 2: Nghệ sĩ yêu thích -->
                    <div class="tab-pane fade" id="artists" role="tabpanel" aria-labelledby="artists-tab">
                        <ul class="list-group">
                            <li v-for="artist in favoriteArtists" :key="artist.id"
                                class="list-group-item d-flex align-items-center justify-content-between">
                                <div class="d-flex align-items-center gap-3">
                                    <img :src="artist.image" alt="" style="width: 75px; height: 75px; object-fit: cover;"
                                        class="rounded-circle" />
                                    <span>{{ artist.title }}</span>
                                </div>
                                <div class="d-flex gap-2">
                                    
                                    <button @click="favoritesStore.removeFavoriteArtist(artist)" class="btn rounded-circle pink-button" style="width: 40px; height: 40px;">
                                        <i class="bi bi-dash"></i>
                                    </button>
                                </div>
                            </li>
                            <li v-if="favoriteArtists.length === 0" class="list-group-item text-center text-muted">Chưa có
                                nghệ sĩ yêu thích</li>
                        </ul>
                    </div>
                </div>


            </aside>
            <article class="col-sm-8 p-5">
                <div class="card p-3" style="background-color: #3f3d56; color: #fff;">
                    <div v-if="song" class="song-detail"
                        style="display: flex; align-items: center; gap: 20px; margin-bottom: 20px;">
                        <img :src="song.image" alt="" class="rounded"
                            style="width: 200px; height: 200px; object-fit: cover;" />
                        <div class="d-flex flex-row gap-3">
                            <button class="btn rounded-circle pink-button" style="width: 120px; height: 120px;">
                                <i class="bi bi-play-fill" style="font-size: 4rem;"></i>
                            </button>
                            <button @click="addToFavorites(song)" class="btn rounded-circle pink-button" style="width: 120px; height: 120px;">
                                <i class="bi bi-plus" style="font-size: 4rem;"></i>
                            </button>
                        </div>
                    </div>

                    <h2>{{ song.title }}</h2>
                    <h4>{{ song.name }}</h4>
                    <br />
                    <pre style="white-space: pre-wrap;">{{ song.lyrics }}</pre>
                </div>
            </article>
        </div>
    </section>
</template>

<script setup>
import { ref } from 'vue'
import img1 from '../assets/images/musicLogo.png'
import img2 from '../assets/images/tadakiminihare.jpg'
import img3 from '../assets/images/lovestory.png'
import img4 from '../assets/images/bacbling.jpg'
import img5 from '../assets/images/yorushika.jpg'
import img6 from '../assets/images/taylorswift.jpg'
import img7 from '../assets/images/ado.jpg'
import img8 from '../assets/images/haru.png'
import img9 from '../assets/images/idol.jpg'
import img10 from '../assets/images/ussewa.jpg'
import img11 from '../assets/images/show.jpg'
import img12 from '../assets/images/gurenge.jpg'
import img13 from '../assets/images/yorunikakeru.jpg'
import img14 from '../assets/images/lionheart.jpg'
import img15 from '../assets/images/unstoppable.jpg'
import img16 from '../assets/images/blankspace.jpg'
import img17 from '../assets/images/legendsneverdie.jpg'
import img18 from '../assets/images/hope.jpg'
import img19 from '../assets/images/youdidntknow.jpg'
import img20 from '../assets/images/whatislove.jpg'
import img21 from '../assets/images/bacbling.jpg'
import img22 from '../assets/images/taylorswiftlover.jpg'
import img23 from '../assets/images/harudorobou.jpg'
import img24 from '../assets/images/lovesickgirls.jpg'
const item = ref([
    { image: img1 },
    { image: img2 },
    { image: img3 },
    { image: img4 },
    { image: img5 },
    { image: img6 },
    { image: img7 },
    { image: img8 },
    { image: img9 },
    { image: img10 },
    { image: img11 },
    { image: img12 },
    { image: img13 },
    { image: img14 },
    { image: img15 },
    { image: img16 },
    { image: img17 },
    { image: img18 },
    { image: img19 },
    { image: img20 },
    { image: img21 },
    { image: img22 },
    { image: img23 },
    { image: img24 }
])

import { useRoute } from 'vue-router'

const route = useRoute()
const songs = [
    { id: 1, title: 'Cruel Summer', name: 'Taylor Swift', image: img22, lyrics: `Fever dream high in the quiet of the night
You know that I caught it (oh yeah, you're right, I want it)
Bad, bad boy, shiny toy with a price
You know that I bought it (oh yeah, you're right, I want it)
Killing me slow, out the window
I'm always waiting for you to be waiting below
Devils roll the dice, angels roll their eyes
What doesn't kill me makes me want you more
And it's new, the shape of your body
It's blue, the feeling I've got
And it's ooh, whoa-oh
It's a cruel summer
"It's cool, " that's what I tell 'em
No rules in breakable heaven
But ooh, whoa-oh
It's a cruel summer with you (yeah, yeah)
Hang your head low in the glow of the vending machine
I'm not dying (oh yeah, you're right, I want it)
You say that we'll just screw it up in these trying times
We're not trying (oh yeah, you're right, I want it)
So cut the headlights, summer's a knife
I'm always waiting for you just to cut to the bone
Devils roll the dice, angels roll their eyes
And if I bleed, you'll be the last to know, oh
It's new, the shape of your body
It's blue, the feeling I've got
And it's ooh, whoa-oh
It's a cruel summer
"It's cool, " that's what I tell 'em
No rules in breakable heaven
But ooh, whoa-oh
It's a cruel summer with you
I'm drunk in the back of the car
And I cried like a baby coming home from the bar (oh)
Said, "I'm fine, " but it wasn't true
I don't wanna keep secrets just to keep you
And I snuck in through the garden gate
Every night that summer, just to seal my fate (oh)
And I screamed, "For whatever it's worth
I love you, ain't that the worst thing you ever heard?"
He looks up, grinnin' like a devil
It's new, the shape of your body
It's blue, the feeling I've got
And it's ooh, whoa-oh
It's a cruel summer
"It's cool, " that's what I tell 'em
No rules in breakable heaven
But ooh, whoa-oh
It's a cruel summer with you
I'm drunk in the back of the car
And I cried like a baby coming home from the bar (oh)
Said, "I'm fine, " but it wasn't true
I don't wanna keep secrets just to keep you
And I snuck in through the garden gate
Every night that summer, just to seal my fate (oh)
And I screamed, "For whatever it's worth
I love you, ain't that the worst thing you ever heard?"
(Yeah, yeah, yeah, yeah)` },
    { id: 2, title: '春泥棒', name: 'ヨルシカ', image: img23, lyrics: '高架橋を抜けたら雲の隙間に青が覗いた\n最近どうも暑いから ただ風が吹くのを待ってた\n木陰に座る\n何か頬に付く\n見上げれば頭上に咲いて散る\nはらり 僕らもう息も忘れて\n瞬きさえ億劫\nさぁ 今日さえ明日過去に変わる\nただ風を待つ\nだから僕らもう声も忘れて\nさよならさえ億劫\nただ花が降るだけ晴れり\n今 春吹雪\n次の日も待ち合わせ\n花見の客も少なくなった\n春の匂いはもう止む\n今年も夏が来るのか\n高架橋を抜けたら道の先に君が覗いた\n残りはどれだけかな\nどれだけ春に会えるだろう\n川沿いの丘 木陰に座る\nまた昨日と変わらず今日も咲く花に\n僕らもう息も忘れて\n瞬きさえ億劫\n花散らせ今吹くこの嵐は\nまさに春泥棒\n風に今日ももう時が流れて\n立つことさえ億劫\n花の隙間に空 散れり\nまだ 春吹雪\n今日も会いに行く\n木陰に座る\n溜息を吐く\n花ももう終わる\n明日も会いに行く\n春がもう終わる\n名残るように時間が散っていく\n愛を歌えば言葉足らず\n踏む韻さえ億劫\n花開いた今を言葉如きが語れるものか\nはらり 僕らもう声も忘れて\n瞬きさえ億劫\n花見は僕らだけ\n散るなまだ 春吹雪\nあともう少しだけ\nもう数えられるだけ\nあと花二つだけ\nもう花一つだけ\nただ葉が残るだけ はらり\n今 春仕舞い' },
    { id: 3, title: 'Lovesick Girls', name: 'BLACKPINK', image: img24, lyrics: "Lovesick girls\nLovesick girls\n영원한 밤\n창문 없는 방에 우릴 가둔 love (love)\nWhat can we say?\n매번 아파도 외치는 love (love)\n다치고 망가져도 나 뭘 믿고 버티는 거야?\n어차피 떠나면 상처투성인 채로 미워하게 될걸\n끝장을 보기 전 끝낼 순 없어\n이 아픔을 기다린 것처럼\n아마 다 잠깐 일지도 몰라\n우린 무얼 찾아서 헤매는 걸까?\nBut I don't care, I'll do it over and over\n내 세상 속엔 너만 있으면 돼\nWe are the lovesick girls\n네 멋대로 내 사랑을 끝낼 순 없어\nWe are the lovesick girls\n이 아픔 없인 난 아무 의미가 없어\nBut we were born to be alone\nYeah, we were born to be alone\nYeah, we were born to be alone\nBut why we still looking for love?\nNo love letters, no X and O's\nNo love, never, my exes know\nNo diamond rings, that set in stone\nTo the left, better left alone\nDidn't wanna be a princess, I'm priceless\nA prince not even on my list\nLove is a drug that I quit\nNo doctor could help when I'm lovesick\n아마 다 잠깐일지도 몰라\n우린 무얼 찾아서 헤매는 걸까?\n불안한 내 눈빛 속에 널 담아\n아프더라도 너만 있으면 돼\nWe are the lovesick girls\n네 멋대로 내 사랑을 끝낼 순 없어\nWe are the lovesick girls\n이 아픔 없인 난 아무 의미가 없어\nBut we were born to be alone\nYeah, we were born to be alone\nYeah, we were born to be alone\nBut why we still looking for love?\n사랑은 slippin' and fallin', 사랑은 killin' your darlin'\n아프다 아물면 또 찾아오는 이 겁 없는 떨림\n들리지 않아 what you say, 이 아픔이 난 행복해\n나를 불쌍해하는 네가 내 눈엔 더 불쌍해\nWe are the lovesick girls\n네 멋대로 내 사랑을 끝낼 순 없어\nWe are the lovesick girls\n이 아픔 없인 난 아무 의미가 없어\n모두 결국 떠나가고\n(Lovesick girls) 내 눈물이 무뎌져도\n(Lovesick girls) 아프고 또 아파도\n(Lovesick girls) but we're still looking for love" },
    { id: 4, title: 'ただ君に晴れ', name: 'ヨルシカ', image: img2, lyrics: '夜に浮かんでいた\n海月のような月が爆ぜた\nバス停の背を覗けば\nあの夏の君が頭にいる\nだけ\n鳥居 乾いた雲 夏の匂いが頬を撫でる\n大人になるまでほら、背伸びしたままで\n遊び疲れたらバス停裏で空でも見よう\nじきに夏が暮れても\nきっときっと覚えてるから\n追いつけないまま大人になって\n君のポケットに夜が咲く\n口に出せないなら僕は1人だ\nそれでいいからもう諦めてる\nだけ\n夏日 乾いた雲 山桜桃海 錆びた標識\n記憶の中はいつも夏の匂いがする\n写真なんて紙切れだ\n思い出なんてただの塵だ\nそれがわからないから、口を噤んだまま\n絶えず君のいこふ 記憶に夏野の石一つ\n俯いたまま大人になって\n追いつけない ただ君に晴れ\n口に出せないまま坂を上った\n僕らの影に夜が咲いていく\n俯いたまま大人になった\n君が思うまま手を叩け\n陽の落ちる坂道を上って\n僕らの影は\n追いつけないまま大人になって\n君のポケットに夜が咲く\n口に出せなくても僕ら一つだ\nそれでいいだろう、もう\n君の思い出を噛み締めてる\nだけ' },
    { id: 5, title: 'What is Love?', name: 'TWICE', image: img20, lyrics: 'TWICE\nWhat is love?\n매일같이 영화 속에서나\n책 속에서나 드라마 속에서 사랑을 느껴\nMm 사랑을 배워\n내 일처럼 자꾸 가슴이 뛰어, 두근두근거려\n설레임에 부풀어 올라\nMm 궁금해서 미칠 것만 같아\nOoh 언젠간 내게도\n이런 일이 실제로 일어날까?\n(Ooh-ooh-ooh)\n그게 언제쯤일까? 어떤 사람일까?\nI wanna know 사탕처럼 달콤하다는데\nI wanna know 하늘을 나는 것 같다는데\nI wanna know, know, know, know\nWhat is love? 사랑이 어떤 느낌인지\nI wanna know 하루 종일 웃고 있다는데\nI wanna know 세상이 다 아름답다는데\nI wanna know, know, know, know\nWhat is love? 언젠간 나에게도 사랑이 올까?\n지금 이런 상상만으로도\n떠올려만 봐도 가슴이 터질 것 같은데\nMm 이렇게 좋은데\n만일 언젠가 진짜로 내게\n사랑이 올 때 난 울어버릴지도 몰라\nMm 정말 궁금해 미칠 것만 같아\nOoh 언젠간 내게도\n이런 일이 실제로 일어날까?\n(Ooh-ooh-ooh)\n그게 언제쯤일까? 어떤 사람일까?\nI wanna know 사탕처럼 달콤하다는데\nI wanna know 하늘을 나는 것 같다는데\nI wanna know, know, know, know\nWhat is love? 사랑이 어떤 느낌인지\nI wanna know 하루 종일 웃고 있다는데\nI wanna know 세상이 다 아름답다는데\nI wanna know, know, know, know\nWhat is love? 언젠간 나에게도 사랑이 올까?\n지금 세상 어느 곳에 살고 있는지\n도대체 언제쯤 나와 만나게 될런지\n언제, 어떻게 우리의 인연은\n시작될런지 모르지만 느낌이 어쩐지\n진, 진, 진짜 좋을 것 같아 왠지\n영화, 드라마보다도 더 멋진\n사랑이 올 거야, 내 예감 언제나 맞지\n어서 나타나봐, 나는 다 준비가 됐지 ready\n찾아낼 거야\n(어디 있을까?) 보고 싶어 죽겠어\n더 이상 참을 수 없을 것만 같아\n사탕처럼 달콤하다는데\n하늘을 나는 것 같다는데\nI wanna know, know, know, know\nWhat is love? 사랑이 어떤 느낌인지\n하루 종일 웃고 있다는데\n세상이 다 아름답다는데\nI wanna know, know, know, know\nWhat is love? 언젠간 나에게도 사랑이 올까?\nI wanna know (ooh)\nI wanna know (what is love?)\n(I wanna know) I wanna know, know, know, know\nWhat is love? (I wanna know, I wanna know)\n(What is love?) I wanna know\nI wanna know\nI wanna know, know, know, know\nWhat is love?\nI wanna know' },
    { id: 6, title: 'Love Story', name: 'Taylor Swift', image: img3, lyrics: "We were both young when I first saw you\nI close my eyes and the flashback starts\nI'm standin' there\nOn a balcony in summer air\nSee the lights, see the party, the ball gowns\nSee you make your way through the crowd\nAnd say, \"Hello\"\nLittle did I know\nThat you were Romeo, you were throwin' pebbles\nAnd my daddy said, \"Stay away from Juliet\"\nAnd I was cryin' on the staircase\nBeggin' you, \"Please don't go, \" and I said\nRomeo, take me somewhere we can be alone\nI'll be waiting, all there's left to do is run\nYou'll be the prince and I'll be the princess\nIt's a love story, baby, just say, \"Yes\"\nSo I sneak out to the garden to see you\nWe keep quiet, 'cause we're dead if they knew\nSo close your eyes\nEscape this town for a little while, oh oh\n'Cause you were Romeo, I was a scarlet letter\nAnd my daddy said, \"Stay away from Juliet\"\nBut you were everything to me\nI was beggin' you, \"Please don't go, \" and I said\nRomeo, take me somewhere we can be alone\nI'll be waiting, all there's left to do is run\nYou'll be the prince and I'll be the princess\nIt's a love story, baby, just say, \"Yes\"\nRomeo, save me, they're tryna tell me how to feel\nThis love is difficult, but it's real\nDon't be afraid, we'll make it out of this mess\nIt's a love story, baby, just say, \"Yes\"\nOh, oh\nI got tired of waiting\nWonderin' if you were ever comin' around\nMy faith in you was fading\nWhen I met you on the outskirts of town, and I said\nRomeo, save me, I've been feeling so alone\nI keep waiting for you, but you never come\nIs this in my head? I don't know what to think\nHe knelt to the ground and pulled out a ring\nAnd said, \"Marry me, Juliet\nYou'll never have to be alone\nI love you and that's all I really know\nI talked to your dad, go pick out a white dress\nIt's a love story, baby, just say, \"Yes\"\nOh, oh, oh\nOh, oh, oh, oh\n'Cause we were both young when I first saw you" },
    { id: 7, title: 'Bắc Bling', name: 'Hòa Minzy', image: img21, lyrics: "Ta về ta tắm ao ta\nDù trong, dù đục, ao nhà vẫn hơn (vẫn hơn)\nTình quê son sắt keo sơn\nHương đồng gió nội, cây rơm đợi chờ\nMời bà con về Bắc Ninh em chơi nào\nBắc Ninh vốn trọng chữ tình\nNón quai thao em đợi ở sân đình\nMấy anh hai quay đầu nhìn cũng đỉnh\nMà các dân chơi gọi là Bắc Bling-ling (Bling-Bling)\nTấm lòng son sắt, ta ngân nga câu quan họ này\nChào mừng về miền đất bến nước và con đò\nTinh hoa không thể nào mất chất ở local\nSửa soạn áo the, khăn xếp, anh em cùng lên đồ\nLet's go\nLướt trên sông như là lướt trên mây\nNgước bên Đông, xong rồi lại ngước bên Tây\nMiếng trầu này em đã ướp thêm say\nMang lời hứa trao duyên như bao hẹn ước đêm nay\nSáng như đêm trăng rằm hội Lim, biết em đâu mà tìm?\nTrót thương em đâu thể ngồi im, cầm khăn í a làm tin\nSáng như đêm trăng rằm hội Lim, biết em đâu mà tìm?\nTrót thương em đâu thể ngồi im, cầm khăn í a, í a làm tin\nĂn một miếng trầu\nĂn một miếng trầu\nĂn vào cho đỏ\nMôi mình, môi ta\nĂn một miếng trầu\nBắc một chiếc cầu\nBao lời chưa ngỏ\nDuyên mình, duyên ta\nMời anh về Bắc Ninh em chơi thăm\nLễ hội nô nức đông vui quanh năm\nQua đền Bà Chúa cầu lộc, cầu tài\nSang rằm tháng Tám ung dung chơi trăng\nĐua thuyền rẽ sóng trên sông Như Nguyệt\nBao sử sách địa linh nhân kiệt\nTam Phủ chốn bồng lai linh thiêng\nNương nhờ cửa thánh, con xin cúi đầu\nNgười ơi-í ơi-ì a-í-a người ở đừng về\nĐể em ngày đêm ngóng trông hình bóng anh khắp bốn bề\nAnh có thương thì qua chứ anh đừng hứa, đừng thề\nVề đây Bắc Ninh cùng em thắm nồng tình quê\nĂn một miếng trầu\nĂn một miếng trầu\nĂn vào cho đỏ\nMôi mình, môi ta\nĂn một miếng trầu\nBắc một chiếc cầu\nBao lời chưa ngỏ\nDuyên mình, duyên ta\nMời anh về Bắc Ninh em chơi thăm\nLễ hội nô nức đông vui quanh năm\nQua đền Bà Chúa cầu lộc, cầu tài\nSang rằm tháng Tám ung dung chơi trăng\nĐua thuyền rẽ sóng trên sông Như Nguyệt\nBao sử sách địa linh nhân kiệt\nTam Phủ chốn bồng lai linh thiêng\nNương nhờ cửa thánh, con xin cúi đầu\nNgười ơi-í ơi-ì a-í-a người ở đừng về\nĐể em ngày đêm ngóng trông hình bóng anh khắp bốn bề\nAnh có thương thì qua chứ anh đừng hứa, đừng thề\nVề đây Bắc Ninh cùng em thắm nồng tình quê" },
    { id: 8, title: '晴る', name: 'ヨルシカ', image: img8, lyrics: "貴方は風のように\n目を閉じては夕暮れ\n何を思っているんだろうか, hmm\n\n目蓋を開いていた\n貴方の目はビイドロ\n少しだけ晴るの匂いがした\n\n晴れに晴れ、花よ咲け\n咲いて晴るのせい\n降り止めば雨でさえ\n貴方を飾る晴る\n胸を打つ音よ凪げ\n僕ら晴る風\nあの雲も越えてゆけ\n遠くまだ遠くまで\n\n貴方は晴れ模様に\n目を閉じては青色\n何が悲しいのだろうか, hmm\n\n目蓋を開いている\n貴方の目にビイドロ\n今少し雨の匂いがした\n\n泣きに泣け、空よ泣け\n泣いて雨のせい\n降り頻る雨でさえ\n雲の上では晴る\n土を打つ音よ鳴れ\n僕ら春荒れ\nあの海も越えてゆく\n遠くまだ遠くまで\n\n通り雨 草を靡かせ\n羊雲 あれも春のせい\n風のよう 胸に春乗せ\n晴るを待つ\n\n晴れに晴れ、空よ裂け\n裂いて春のせい\n降り止めば雨でさえ\n貴方を飾る晴る\n胸を打つ音奏で\n僕ら春風\n音に聞く晴るの風\nさぁこの歌よ凪げ！\n\n晴れに晴れ、花よ咲け\n咲いて春のせい\nあの雲も越えてゆけ\n遠くまだ遠くまで" },
    { id: 9, title: 'アイドル', name: 'YOASOBI', image: img9, lyrics: "無敵の笑顔で荒らすメディア\n知りたいその秘密ミステリアス\n抜けてるとこさえ彼女のエリア\n完璧で嘘つきな君は\n天才的なアイドル様\n(You're my savior, you're my saving grace)\n\n今日何食べた？好きな本は？\n遊びに行くならどこに行くの？\n何も食べてない それは内緒\n何を聞かれてものらりくらり\nそう淡々と だけど燦々と\n見えそうで見えない秘密は蜜の味\nあれもないないない これもないないない\n好きなタイプは？相手は？さあ答えて\n\n「誰かを好きになること\nなんて私分からなくてさ」\n嘘か本当か知り得ない\nそんな言葉にまた一人堕ちる\nまた好きにさせる\n\n誰もが目を奪われていく\n君は完璧で究極のアイドル\n金輪際現れない\n一番星の生まれ変わり\nAh, その笑顔で愛してるで\n誰も彼も虜にしていく\nその瞳がその言葉が\n嘘でもそれは完全なアイ\n\nはいはいあの子は特別です\n我々はハナからおまけです\nお星様の引き立て役 B です\n全てがあの子のお陰なわけない\n洒落臭い\n妬み嫉妬なんてないわけがない\nこれはネタじゃない\nからこそ許せない\n完璧じゃない君じゃ許せない\n自分を許せない\n誰よりも強い君以外は認めない\n\n誰もが信じ崇めてる\nまさに最強で無敵のアイドル\n弱点なんて見当たらない\n一番星を宿している\n弱いとこなんて見せちゃダメダメ\n知りたくないとこは見せずに\n唯一無二じゃなくちゃイヤイヤ\nそれこそ本物のアイ\n\n得意の笑顔で沸かすメディア\n隠しきるこの秘密だけは\n愛してるって嘘で積むキャリア\nこれこそ私なりの愛だ\n流れる汗も綺麗なアクア\nルビーを隠したこの瞼\n歌い踊り舞う私はマリア\nそう嘘はとびきりの愛だ\n\n誰かに愛されたことも\n誰かのこと愛したこともない\nそんな私の嘘がいつか本当になること\n信じてる\n\nいつかきっと全部手に入れる\n私はそう欲張りなアイドル\n等身大でみんなのこと\nちゃんと愛したいから\n今日も嘘をつくの\nこの言葉がいつか本当になる日を願って\nそれでもまだ\n君と君にだけは言えずにいたけど\n\nあぁ、やっと言えた\nこれは絶対嘘じゃない\n愛してる\n(You're my savior, my true savior, my saving grace)" },
    { id: 10, title: 'うっせぇわ', name: 'Ado', image: img10, lyrics: "正しさとは 愚かさとは\nそれが何か見せつけてやる\nちっちゃな頃から優等生\n気づいたら大人になっていた\nナイフの様な思考回路\n持ち合わせる訳もなく\nでも遊び足りない 何か足りない\n困っちまうこれは誰かのせい\nあてもなくただ混乱するエイデイ\nそれもそっか\n最新の流行は当然の把握\n経済の動向も通勤時チェック\n純情な精神で入社しワーク\n社会人じゃ当然のルールです\nはぁ？うっせぇうっせぇうっせぇわ\nあなたが思うより健康です\n一切合切凡庸な\nあなたじゃ分からないかもね\n嗚呼よく似合う\nその可もなく不可もないメロディー\nうっせぇうっせぇうっせぇわ\n頭の出来が違うので問題はナシ\nつっても私模範人間\n殴ったりするのはノーセンキュー\nだったら言葉の銃口を\nその頭に突きつけて撃てば\nマジヤバない？止まれやしない\n不平不満垂れて成れの果て\nサディスティックに変貌する精神\nクソだりぃな\n酒が空いたグラスあれば直ぐに注ぎなさい\n皆がつまみ易いように串外しなさい\n会計や注文は先陣を切る\n不文律最低限のマナーです\nはぁ？うっせぇうっせぇうっせぇわ\nくせぇ口塞げや限界です\n絶対絶対現代の代弁者は私やろがい\nもう見飽きたわ\n二番煎じ言い換えのパロディ\nうっせぇうっせぇうっせぇわ\n丸々と肉付いたその顔面にバツ\nうっせぇうっせぇうっせぇわ\nうっせぇうっせぇうっせぇわ\n私が俗に言う天才です\nうっせぇうっせぇうっせぇわ\nあなたが思うより健康です\n一切合切凡庸な\nあなたじゃ分からないかもね\n嗚呼つまらねぇ\n何回聞かせるんだそのメモリー\nうっせぇうっせぇうっせぇわ\nアタシも大概だけど\nどうだっていいぜ問題はナシ" },
    { id: 11, title: 'Show', name: 'Ado', image: img11, lyrics: "Okay たちまち独壇場 listen, listen\n(Nah-nah-nah-nah-nah, ready for my show)\n傾け\n振り切ろう (Giga, TeddyLoid)\nHuh ヤーヤーヤーヤーヤー 唱タイム\n天辺の御成り ほらおいで\n宵をコンプリートオーライ hell yeah, yeah, yeah, yeah\nだんだんノリノリで超簡単 brah, brah, brah! Pow\nえも言われない ain't nobody stop (ha, ha)\nオイ 全土絢爛豪華 attention 騒ごうか\n意思表示にもうじき衝撃の声高らか堂々登板\nもう伽藍洞は疾っくの疾う淘汰\nAy 繚乱桜花 御出ましだ\n格好つけてるつもりは no, no\nオートマティックに溢れちゃう本能\n宣う断頭台の上で 燥げ華麗\nDa-rat-a-tat-a-tat, warning!\nNah-nah-nah-nah-nah, ready for my show\nバンザイ 遊ぶ気に寿 shout it out, shout it out\nNah-nah-nah-nah-nah, ready for my show\nはんなり 感情通りに八艘飛び\nShout it out, shout it out (ooh)\n食らっちゃいな\n(Hey, ha) rat-a-tat-tat-tat\n(Pull up) hey, uh, brah, brah, pow\n満開 総員一気にとびきり jump around\nLook at me now\n皮膚を破りそうな程に\n跳ねる心臓くらい激情的仕様 (exotic vox)\nイニミニマニモ ご来場からのご来光\nかくれんぼしてるその気持ち解放\n（理性アディオス）\nしゃかりきじみちゃう (ay, ay, ay, ay)\n蛇腹刃蛇尾 騙る二枚刃\n野心家嫉妬するようなジュース\nたぶらかすな かっとなっちゃ嫌\nカルマに至る前に揺蕩うわ\n蛇腹刃蛇尾 騙る二枚刃\n野心家 嫉妬するようなジュース\nたぶらかすな かっとなっちゃ嫌\n十色のバタフライ (no escape)\nご存じの通り 騒々しい鼓動に\n絆されてもう止まれない ay\n衝動に塗装し描いた daybreak\n肺貫通 低音狂\n異例の危険度 比類なき活気充満\n(Nah-nah-nah-nah-nah, ready for my show)\nいちかばちか 鳴呼\nNah-nah-nah-nah-nah, ready for my show\nバンザイ 遊ぶ気に寿 shout it out, shout it out\nNah-nah-nah-nah-nah, ready for my show\n喝采 巻き起こすために stay\n一切合切忘れて shout it out\nAy, yeah\nWhoa 右に左 まとめて rat-a-tat-a-tat (pull up)\n思いっ切り一気に (clap, clap, clap)\nなにはともあれ ご唱和あれ\nShout it out, shout it out" },
    { id: 12, title: '紅蓮華', name: 'LiSA', image: img12, lyrics: "強くなれる理由を知った\n僕を連れて進め\n\n泥だらけの走馬灯に酔う こわばる心\n震える手は掴みたいものがある それだけさ\n夜の匂いに (I'll spend all thirty nights)\n空睨んでも (Staring into the sky)\n変わっていけるのは自分自身だけ それだけさ\n\n強くなれる理由を知った\n僕を連れて進め\n\nどうしたって\n消せない夢も 止まれない今も\n誰かのために強くなれるなら\nありがとう 悲しみよ\n世界に打ちのめされて負ける意味を知った\n紅蓮の華よ咲き誇れ！ 運命を照らして\n\nイナビカリの雑音が耳を刺す 戸惑う心\n優しいだけじゃ守れないものがある？ わかってるけど\n水面下で絡まる善悪 透けて見える偽善に天罰\nTell me why, tell me why, tell me why, tell me, I don't need you!\n逸材の花より 挑み続け咲いた一輪が美しい\n\n乱暴に敷き詰められた トゲだらけの道も\n本気の僕だけに現れるから 乗り越えてみせるよ\n簡単に片付けられた 守れなかった夢も\n紅蓮の心臓に根を生やし この血に宿ってる\n\n人知れず儚い 散りゆく結末\n無情に破れた 悲鳴の風吹く\n誰かの笑う影 誰かの泣き声\n誰もが幸せを願ってる\n\nどうしたって\n消せない夢も 止まれない今も\n誰かのために強くなれるなら\nありがとう 悲しみよ\n世界に打ちのめされて負ける意味を知った\n紅蓮の華よ咲き誇れ！ 運命を照らして" },
    { id: 13, title: '夜に駆ける', name: 'YOASOBI', image: img13, lyrics: "沈むように溶けてゆくように\n二人だけの空が広がる夜に\n\n「さよなら」だけだった\nその一言で全てが分かった\n日が沈み出した空と君の姿\nフェンス越しに重なっていた\n初めて会った日から\n僕の心の全てを奪った\nどこか儚い空気を纏う君は\n寂しい目をしてたんだ\n\nいつだってチックタックと\n鳴る世界で何度だってさ\n触れる心無い言葉うるさい声に\n涙が零れそうでも\nありきたりな喜びきっと二人なら見つけられる\n\n騒がしい日々に笑えない君に\n思い付く限り眩しい明日を\n明けない夜に落ちてゆく前に\n僕の手を掴んでほら\n忘れてしまいたくて閉じ込めた日々も\n抱きしめた温もりで溶かすから\n怖くないよいつか日が昇るまで\n二人でいよう\n\n君にしか見えない\n何かを見つめる君が嫌いだ\n見惚れているかのような恋するような\nそんな顔が嫌いだ\n\n信じていたいけど信じれないこと\nそんなのどうしたってきっと\nこれからだっていくつもあって\nそのたんび怒って泣いていくの\nそれでもきっといつかはきっと僕らはきっと\n分かり合えるさ信じてるよ\n\nもう嫌だって疲れたんだって\nがむしゃらに差し伸べた僕の手を振り払う君\nもう嫌だって疲れたよなんて\n本当は僕も言いたいんだ\n\nほらまたチックタックと\n鳴る世界で何度だってさ\n君の為に用意した言葉どれも届かない\n「終わりにしたい」だなんてさ\n釣られて言葉にした時\n君は初めて笑った\n\n騒がしい日々に笑えなくなっていた\n僕の目に映る君は綺麗だ\n明けない夜に溢れた涙も\n君の笑顔に溶けていく\n変わらない日々に泣いていた僕を\n君は優しく終わりへと誘う\n沈むように溶けてゆくように\n染み付いた霧が晴れる\n忘れてしまいたくて閉じ込めた日々に\n差し伸べてくれた君の手を取る\n涼しい風が空を泳ぐように今吹き抜けていく\n\n繋いだ手を離さないでよ\n二人今, 夜に駆け出していく" },
    { id: 14, title: 'Lion Heart', name: 'Girls\' Generation', image: img14, lyrics: "Ooh, 너와 나 첨 만났을 때\nOoh, 마치 사자처럼 맴돌다\n기회를 노려 내 맘 뺏은 너\nAh, 넌 달라진 게 없어 여전해\n난 애가 타고 또 타\n사냥감 찾아 한 눈 파는 너\n수백 번 밀어내야 했는데 (ooh-ooh)\n수천 번 널 떠나야 했는데\nTell me why\n왜 맘이, 맘이 자꾸 흔들리니?\n난 여기, 여기 네 옆에 있잖니\n정신 차려, lion heart\n난 애가 타\n내 맘이, 맘이 더는 식지 않게\n난 여기저기 뛰노는 너의 맘\n길들일래, lion heart\nOh-oh-oh, oh-oh-oh, oh-oh\nOh-oh-oh, oh-oh-oh, oh-oh\nOoh, 넌 자유로운 영혼 여전해\n충실해 본능 앞에\n지금 네 옆에 난 안 보이니?\n수백 번 고민 고민해봐도 (ooh-ooh)\n수천 번 결국 답은 너인데\nTell me why\n왜 맘이, 맘이 자꾸 흔들리니?\n난 여기, 여기 네 옆에 있잖니\n정신 차려, lion heart\n난 애가 타\n내 맘이, 맘이 더는 식지 않게\n난 여기저기 뛰노는 너의 맘\n길들일래, lion heart\noh-oh-oh, oh-oh-oh, oh-oh\n(큰일 났어) oh-oh-oh, oh-oh-oh, oh-oh (곤히 잠자는 나의 코끝을, baby)\n(큰일 났어) oh-oh-oh, oh-oh-oh, oh-oh (혼 좀 나 볼래)\nOh-oh-oh, oh-oh-oh, oh-oh (네가 건드려, 나도 화가 나, baby)\nTell me why (baby, why?)\n왜 맘이, 맘이 자꾸 흔들리니? (흔들리니?)\n난 여기, 여기 네 옆에 있잖니 (whoa)\nOh, 정신 차려, lion heart (yeah, yeah)\n난 애가 타\n내 맘이, 맘이 더는 식지 않게 (않게, 않게)\n난 여기저기 뛰노는 너의 맘\nOoh, 난 길들일래, lion heart (길들일래, lion heart)\nLadies, y'all know what I'm talking about, right? (Yeah)\n모두 다 아니라 해도 좋을 때 있지 않아\n사실 나만 좋음 됐지, 뭐\n바람보다 빠른 눈치로 (맘은 뜨겁게)\n햇살처럼 따뜻한 말로 (머린 차갑게)\n길들일래 너의 lion heart\n사자 같은 너의 lion heart\nOh-oh-oh, oh-oh-oh, oh-oh (la-la-la, la-la-la-la-la)\n(오늘부터) 여기 와서 앉아\nOh-oh-oh, oh-oh-oh, oh-oh (la-la-la, la-la-la-la-la)\n(오늘부터) 내 곁에만 있어\nOh-oh-oh, oh-oh-oh, oh-oh (la-la-la, la-la-la-la-la)\n(오늘부터) 한 눈 팔지 말아, lion heart" },
    { id: 15, title: 'Unstoppable', name: 'Sia', image: img15, lyrics: "All smiles, I know what it takes to fool this town\nI'll do it 'til the sun goes down\nAnd all through the nighttime\nOh, yeah\nOh, yeah, I'll tell you what you wanna hear\nLeave my sunglasses on while I shed a tear\nIt's never the right time\nYeah, yeah\nI put my armor on, show you how strong I am (am)\nI put my armor on, I'll show you that I am\nI'm unstoppable\nI'm a Porsche with no brakes\nI'm invincible\nYeah, I win every single game\nI'm so powerful\nI don't need batteries to play\nI'm so confident\nYeah, I'm unstoppable today\nUnstoppable today\nUnstoppable today\nUnstoppable today\nI'm unstoppable today\nBreak down, only alone I will cry out now\nYou'll never see what's hiding out\nHiding out deep down\nYeah, yeah\nI know, I've heard that to let your feelings show\nIs the only way to make friendships grow\nBut I'm too afraid now\nYeah, yeah\nI put my armor on, show you how strong I am (am)\nI put my armor on, I'll show you that I am\nI'm unstoppable\nI'm a Porsche with no brakes\nI'm invincible\nYeah, I win every single game\nI'm so powerful\nI don't need batteries to play\nI'm so confident\nYeah, I'm unstoppable today\nUnstoppable today\nUnstoppable today\nUnstoppable today\nI'm unstoppable today\nUnstoppable today\nUnstoppable today\nUnstoppable today\nI'm unstoppable today\nI put my armor on, show you how strong I am\nI put my armor on, I'll show you that I am\nI'm unstoppable\nI'm a Porsche with no brakes\nI'm invincible\nYeah, I win every single game\nI'm so powerful\nI don't need batteries to play\nI'm so confident\nYeah, I'm unstoppable today\nUnstoppable today\nUnstoppable today\nUnstoppable today\nI'm unstoppable today\nUnstoppable today\nUnstoppable today\nUnstoppable today\nI'm unstoppable today" },
    { id: 16, title: 'Blank Space', name: 'Taylor Swift', image: img16, lyrics: "Nice to meet you, where you been?\nI could show you incredible things\nMagic, madness, heaven, sin\nSaw you there and I thought\n'Oh, my God, look at that face\nYou look like my next mistake\nLove's a game, wanna play?'' Ay\nNew money, suit and tie\nI can read you like a magazine\nAin't it funny? Rumors fly\nAnd I know you heard about me\nSo, hey, let's be friends\nI'm dying to see how this one ends\nGrab your passport and my hand\nI can make the bad guys good for a weekend\nSo, it's gonna be forever\nOr it's gonna go down in flames?\nYou can tell me when it's over, mm\nIf the high was worth the pain\nGot a long list of ex-lovers\nThey'll tell you I'm insane\n'Cause you know I love the players\nAnd you love the game\n'Cause we're young and we're reckless\nWe'll take this way too far\nIt'll leave you breathless, mm\nOr with a nasty scar\nGot a long list of ex-lovers\nThey'll tell you I'm insane\nBut I've got a blank space, baby\nAnd I'll write your name\nCherry lips, crystal skies\nI could show you incredible things\nStolen kisses, pretty lies\nYou're the king, baby, I'm your queen\nFind out what you want\nBe that girl for a month\nWait, the worst is yet to come, oh, no\nScreaming, crying, perfect storms\nI can make all the tables turn\nRose garden filled with thorns\nKeep you second guessing, like\n'Oh, my God, who is she?'\nI get drunk on jealousy\nBut you'll come back each time you leave\n'Cause, darling, I'm a nightmare dressed like a daydream\nSo, it's gonna be forever\nOr it's gonna go down in flames?\nYou can tell me when it's over, mm\nIf the high was worth the pain\nGot a long list of ex-lovers\nThey'll tell you I'm insane\n'Cause you know I love the players\nAnd you love the game\n'Cause we're young and we're reckless (oh)\nWe'll take this way too far\nIt'll leave you breathless, mm (oh-oh)\nOr with a nasty scar\nGot a long list of ex-lovers\nThey'll tell you I'm insane (insane)\nBut I've got a blank space, baby\nAnd I'll write your name\nBoys only want love if it's torture\nDon't say I didn't, say I didn't warn ya\nBoys only want love if it's torture\nDon't say I didn't, say I didn't warn ya\nSo, it's gonna be forever\nOr it's gonna go down in flames?\nYou can tell me when it's over, mm (over)\nIf the high was worth the pain\nGot a long list of ex-lovers\nThey'll tell you I'm insane (I'm insane)\n'Cause you know I love the players\nAnd you love the game (love the game)\n'Cause we're young and we're reckless (yeah)\nWe'll take this way too far (ooh)\nIt'll leave you breathless, mm\nOr with a nasty scar (or leave a nasty scar)\nGot a long list of ex-lovers\nThey'll tell you I'm insane\nBut I've got a blank space, baby\nAnd I'll write your name" },
    { id: 17, title: 'Legends Never Die', name: 'League of Legends', image: img17, lyrics: "Legends never die\nWhen the world is calling you\nCan you hear them screaming out your name?\nLegends never die\nThey become a part of you\nEvery time you bleed for reaching greatness\nRelentless you survive\nThey never lose hope when everything's cold\nAnd the fighting's near\nIt's deep in their bones, they'll run into smoke\nWhen the fire is fierce\nOh, pick yourself up, 'cause\nLegends never die\nWhen the world is calling you (the world is calling you)\nCan you hear them screaming out your name?\nLegends never die\nThey become a part of you (they become a part of you)\nEvery time you bleed for reaching greatness\nLegends never die\nThey're written down in eternity\nBut you'll never see the price it costs\nThe scars collected all of their lives\nWhen everything's lost, they pick up their hearts\nAnd avenge defeat\nBefore it all starts, they suffer through harm\nJust to touch a dream\nOh, pick yourself up, 'cause\nLegends never die\nWhen the world is calling you (when the world is calling you)\nCan you hear them screaming out your name?\nLegends never die\nThey become a part of you (they become a part of you)\nEvery time you bleed for reaching greatness\nLegends never die\nWhen the world is calling out your name\nBegging you to fight\nPick yourself up once more\nPick yourself up, 'cause\nLegends never die\nWhen the world is calling you (when the world is calling you)\nCan you hear them screaming out your name?\nLegends never die\nThey become a part of you (they become a part of you)\nEvery time you bleed for reaching greatness\nLegends never die" },
    { id: 18, title: 'Hope Is the Thing With Feathers', name: 'Robin', image: img18, lyrics: "We rise together as our destiny unfolds\nWe face the darkness and our trials are yet untold\nThrough the shadows of despair\nOh, in silence, hopes we share, woah-woah\nTo chase our dreams that we've declared\n\nWe glimpse, through our eyes\nYet fools, blind our sights\nCan't make what they say\nWe'll find our way, we'll find our way\n\nHeads up! The wheels are spinning\nAcross the plains, in valleys deep\nTo dawn, the wheels that sing\nAn unending dream!\nHeads up! Thе tracks are running\nAcross the plains, wherе shadows hide\nWe run, we stride, woah-oh\n\nIn the face of fear and plight\nAnd yet we hold our ground, woah\nIn life we stand and strive\nOur victory is found\n\nAnd the storms we've weathered through\nAnd we hope in the light of truth, woah-oh\nTo break free from chains and come anew\n\nHeads up! The wheels are spinning\nAcross the plains, in valleys deep\nTo dawn, the wheels that sing\nAn unending dream!\nHeads up! The tracks are running\nAcross the plains, where shadows hide\nWe run, we stride, woah-oh\n\n(Woah, woah, woah, woah)\n(Woah, woah, woah, woah)\nWoah, woah, woah, woah\nWoah, woah, woah, woah\n\nHeads up! A steady rhythm\nA destination that's ever near\nIt comes! Stride to our kingdom\nAnd see the light of day\nHeads up! The wheels are singing\nThe whispers and secrets they'd keep\nTo hope! We bound, woah-oh\n\nBreak free, we chased our dreams, beneath the starry night\nIn the face of god, we rose, as one" },
    { id: 19, title: 'You Didn’t Know', name: 'Hazbin Hotel', image: img19, lyrics: "But she was right, Sera\nShe showed us a soul can improve\nHe saw the light, Sera\nChecked all the boxes that you said would\nProve a person deserves a second chance\nNow we turn our backs, no second glance?\nIt's not as simple as you think\nNot everything is spelled in ink\nIt's not fair, Sera\nCareful, Charlie, keep a cool head\nNo! Don't you care, Sera?\nThat just because someone is dead\nIt doesn't mean they can't resolve to change their ways\nTurn the page, escape infernal blaze\nI'm sure you wish it could be so\nBut there's a lot that you don't know\nWhat are we even talking about?\nSome crack-whore who fucked up already\nHe blew his shot like the cocks in his mouth\nThis discussion is senseless and petty\nThere's no question to be posed\nHe's unholy, case closed\nDid you forget that Hell is forever?\nA man only lives once\nWe'll see you in one month\nGotta say, I can't wait to (Adam)\nCome down and exterminate you\nWait! (Shit)\nWhat are you saying? Let me get this straight\nYou go down there and kill those poor souls?\nYou didn't know? (Whoops!)\nGuess the cat's out of the bag (what's the big deal?)\nSera, tell me that you didn't know\nI thought since I'm older, it's my load to shoulder (no)\nYou have to listen, it was such a hard decision\nI wanted to save you the anguish it takes to\nDo what was required\nTo think that I admired you\nWell, I don't need your condescension\nI'm not a child to protect\nWas talk of virtue just pretension?\nWas I too naive to expect you to heed the morals you're purveying?\nThat's what the fuck I've been saying!\nIf Hell is forever, then Heaven must be a lie (Emily!)\nIf angels can do whatever and remain in the sky\nThe rules are shades of gray when you don't do as you say\nWhen you make the wretched suffer just to kill them again\nI was told not to trust in angels (by her?)\nHah, she should know (we should go)\nNo! Don't you see? We've come so close\nLook at them fighting, they're at each other's throats\nDon't you act all high and mighty\nDid you ever think your little girlfriend might be a liar?\nDon't, Adam, please! (What's the fuss?)\nWhy hide the fact that you're an angel, just like us?" }
]

const song = songs.find(s => s.id === parseInt(route.params.id))
import { computed } from 'vue'
import { useFavoritesStore } from '../favorites.js'

const favoritesStore = useFavoritesStore()
const favoriteSongs = computed(() => favoritesStore.favorites)
const favoriteArtists = computed(() => favoritesStore.favoriteArtist)

function addToFavorites(song) {
  favoritesStore.addFavorite(song)
}
</script>

<style scoped>
.tab-content .container {
    max-width: 90% !important;
}

.container {
    margin-top: 40px;
}

h3 {
    color: #42399f;
    font-weight: 600;
    text-align: center;
    margin-bottom: 30px;
}

.custom-search {
    background-color: #3f3d56;
    border-radius: 12px;
    box-shadow: inset 0 0 0 1px #555;
    transition: box-shadow 0.3s ease, background-color 0.3s ease;
    height: 52px;
    /* Tăng chiều cao khung */
}

.custom-search:hover {
    box-shadow: 0 0 6px rgba(255, 255, 255, 0.2);
}

.custom-search-input {
    background-color: #3f3d56;
    color: white;
    border: none;
    border-radius: 0 12px 12px 0;
    height: 100%;
    /* Chiều cao bằng nhóm input */
    font-size: 1rem;
}

.custom-search-input:focus {
    outline: none;
    box-shadow: none;
    background-color: #484660;
    color: white;
}

.input-group-text {
    background-color: #3f3d56;
    border: none;
    border-radius: 12px 0 0 12px;
    height: 100%;
}

.input-group-text i {
    color: white;
    font-size: 1.2rem;
}

.custom-search-input::placeholder {
    color: white;
    opacity: 1;
    /* Đảm bảo không bị mờ nhạt */
}

.nav-tabs .nav-link.active {
    background-color: #ff38ca;
    color: #3f3d56;
    border: none;
    border-radius: 8px 8px 0 0;
}

.nav-tabs .nav-link {
    color: #ff38ca;
    font-weight: 500;
}

.carousel-item img {
    transition: transform 4s ease;
}

.carousel-item.active img {
    transform: scale(1.05);
}

.pink-button {
    background-color: #ffc0e0;
    border: none;
    transition: all 0.3s ease;
}

.pink-button i {
    color: #ff38ca;
    font-size: 1.2rem;
    transition: transform 0.3s ease, color 0.3s ease;
}

.pink-button:hover {
    background-color: #ffaad8;
    /* màu hồng đậm hơn khi hover */
    transform: scale(1.1);
    /* phóng to nhẹ toàn bộ nút */
}

.pink-button:hover i {
    color: #e60099;
    /* đổi màu icon khi hover */
    transform: scale(1.2);
    /* phóng to icon nhẹ */
}

.card img:hover {
    transform: scale(1.1);
    transition: transform 0.8s ease;
}

aside .list-group-item {
    background-color: #555272;
    color: white;
}

aside .list-group-item:hover {
    background-color: #726e97;
}
</style>