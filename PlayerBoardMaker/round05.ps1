#round5 setup

$round = 5

$fa_ami = 2
$fa_mami = 2
$fa_hibiki = 2

$fa_ami_played = 0 
$fa_mami_played = 0 
$fa_hibiki_played = 0 

$dir = "round{0:00}" -f $round

# ディレクトリが無ければ作成
if( (Test-Path $dir) -eq 0 ) { mkdir $dir }

# init state
scala PlayerResourceWriter board_hibiki_01.png `
 ("round{0:00}\hibiki_{0}_{1:00}.png" -f $round, $fa_hibiki_played) `
 "fa=$($fa_hibiki-$fa_hibiki_played)" fo=1 sp=1 cl=4 st=1 gr=1 re=2 wo=6
scala PlayerResourceWriter board_ami_01.png `
 ("round{0:00}\ami_{0}_{1:00}.png" -f $round, $fa_ami_played) `
 "fa=$($fa_ami-$fa_ami_played)" fo=2 sp=0 re=2
scala PlayerResourceWriter board_mami.png `
 ("round{0:00}\mami_{0}_{1:00}.png" -f $round, $fa_mami_played) `
 "fa=$($fa_mami-$fa_ami_played)" fo=5 sp=0 re=2 wo=6 sh=1 st=1

$fa_ami_played++
$fa_mami_played++
$fa_hibiki_played++

# １回目
scala PlayerResourceWriter board_hibiki_02.png `
 ("round{0:00}\hibiki_{0}_{1:00}.png" -f $round, $fa_hibiki_played) `
 "fa=$($fa_hibiki-$fa_hibiki_played)" fo=1 sp=1 cl=4 st=1 gr=1 wo=1
scala PlayerResourceWriter board_ami_01.png `
 ("round{0:00}\ami_{0}_{1:00}.png" -f $round, $fa_ami_played) `
 "fa=$($fa_ami-$fa_ami_played)" fo=4 sp=1 re=2
scala PlayerResourceWriter board_hibiki_02.png `
 ("round{0:00}\hibiki_{0}_{1:00}a.png" -f $round, $fa_hibiki_played) `
 "fa=$($fa_hibiki-$fa_hibiki_played)" fo=1 sp=0 cl=4 st=1 gr=1 wo=1
scala PlayerResourceWriter board_mami.png `
 ("round{0:00}\mami_{0}_{1:00}.png" -f $round, $fa_mami_played) `
 "fa=$($fa_mami-$fa_ami_played)" fo=5 sp=0 re=2 wo=9 sh=1 st=1

$fa_ami_played++
$fa_mami_played++
$fa_hibiki_played++

# ２回目
scala PlayerResourceWriter board_hibiki_02.png `
 ("round{0:00}\hibiki_{0}_{1:00}.png" -f $round, $fa_hibiki_played) `
 "fa=$($fa_hibiki-$fa_hibiki_played)" fo=1 sp=0 cl=4 st=1 gr=2 wo=1
scala PlayerResourceWriter board_ami_01.png `
 ("round{0:00}\ami_{0}_{1:00}.png" -f $round, $fa_ami_played) `
 "fa=$($fa_ami-$fa_ami_played)" fo=4 sp=1 re=2 sh=2
scala PlayerResourceWriter board_mami.png `
 ("round{0:00}\mami_{0}_{1:00}.png" -f $round, $fa_mami_played) `
 "fa=$($fa_mami-$fa_ami_played)" fo=5 sp=0 re=2 wo=10 sh=1 st=2

