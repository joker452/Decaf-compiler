VTABLE(_Animal) {
    <empty>
    Animal
    _Animal.InitAnimal;
    _Animal.GetHeight;
    _Animal.GetMom;
}

VTABLE(_Cow) {
    _Animal
    Cow
    _Animal.InitAnimal;
    _Animal.GetHeight;
    _Animal.GetMom;
    _Cow.InitCow;
    _Cow.IsSpottedCow;
}

VTABLE(_Main) {
    <empty>
    Main
}

FUNCTION(_Animal_New) {
memo ''
_Animal_New:
    _T10 = 12
    parm _T10
    _T11 =  call _Alloc
    _T12 = 0
    *(_T11 + 4) = _T12
    *(_T11 + 8) = _T12
    _T13 = VTBL <_Animal>
    *(_T11 + 0) = _T13
    return _T11
}

FUNCTION(_Cow_New) {
memo ''
_Cow_New:
    _T14 = 16
    parm _T14
    _T15 =  call _Alloc
    _T16 = 0
    *(_T15 + 4) = _T16
    *(_T15 + 8) = _T16
    *(_T15 + 12) = _T16
    _T17 = VTBL <_Cow>
    *(_T15 + 0) = _T17
    return _T15
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T18 = 4
    parm _T18
    _T19 =  call _Alloc
    _T20 = VTBL <_Main>
    *(_T19 + 0) = _T20
    return _T19
}

FUNCTION(_Animal.InitAnimal) {
memo '_T0:4 _T1:8 _T2:12'
_Animal.InitAnimal:
    _T21 = *(_T0 + 4)
    *(_T0 + 4) = _T1
    _T22 = *(_T0 + 8)
    *(_T0 + 8) = _T2
}

FUNCTION(_Animal.GetHeight) {
memo '_T3:4'
_Animal.GetHeight:
    _T23 = *(_T3 + 4)
    return _T23
}

FUNCTION(_Animal.GetMom) {
memo '_T4:4'
_Animal.GetMom:
    _T24 = *(_T4 + 8)
    return _T24
}

FUNCTION(_Cow.InitCow) {
memo '_T5:4 _T6:8 _T7:12 _T8:16'
_Cow.InitCow:
    _T25 = *(_T5 + 12)
    *(_T5 + 12) = _T8
    parm _T5
    parm _T6
    parm _T7
    _T26 = *(_T5 + 0)
    _T27 = *(_T26 + 8)
    call _T27
}

FUNCTION(_Cow.IsSpottedCow) {
memo '_T9:4'
_Cow.IsSpottedCow:
    _T28 = *(_T9 + 12)
    return _T28
}

FUNCTION(main) {
memo ''
main:
    _T31 =  call _Cow_New
    _T29 = _T31
    _T32 = 5
    _T33 = 0
    _T34 = 1
    parm _T29
    parm _T32
    parm _T33
    parm _T34
    _T35 = *(_T29 + 0)
    _T36 = *(_T35 + 20)
    call _T36
    _T30 = _T29
    parm _T30
    _T37 = *(_T30 + 0)
    _T38 = *(_T37 + 16)
    _T39 =  call _T38
    _T41 = VTBL <_Cow>
    _T42 = *(_T30 + 0)
_L17:
    _T40 = (_T41 == _T42)
    if (_T40 != 0) branch _L18
    _T42 = *(_T42 + 0)
    if (_T42 != 0) branch _L17
    _T40 = 0
_L18:
    parm _T40
    call _PrintBool
    _T44 = VTBL <_Cow>
    _T45 = *(_T30 + 0)
_L19:
    _T43 = (_T44 == _T45)
    if (_T43 != 0) branch _L20
    _T45 = *(_T45 + 0)
    if (_T45 != 0) branch _L19
    _T46 = "Decaf runtime error: "
    parm _T46
    call _PrintString
    _T47 = *(_T30 + 0)
    _T48 = *(_T47 + 4)
    parm _T48
    call _PrintString
    _T49 = " cannot be cast to "
    parm _T49
    call _PrintString
    _T50 = VTBL <_Cow>
    _T51 = *(_T50 + 4)
    parm _T51
    call _PrintString
    _T52 = "\n"
    parm _T52
    call _PrintString
    call _Halt
_L20:
    _T29 = _T30
    _T53 = "spots: "
    parm _T53
    call _PrintString
    parm _T29
    _T54 = *(_T29 + 0)
    _T55 = *(_T54 + 24)
    _T56 =  call _T55
    parm _T56
    call _PrintBool
    _T57 = "    height: "
    parm _T57
    call _PrintString
    parm _T30
    _T58 = *(_T30 + 0)
    _T59 = *(_T58 + 12)
    _T60 =  call _T59
    parm _T60
    call _PrintInt
}

