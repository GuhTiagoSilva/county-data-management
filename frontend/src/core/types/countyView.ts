export type CountyView = {
    id: 1;
    name: string;
    population: number;
    websiteLink: string;
    application: string;
    budgetedValue: number;
    collectedValue: number;
    incomeDate: string;
    type: number;
}

export type CountyPage = {
    content?: CountyView[];
    last: boolean;
    totalPages: number;
    totalElements: number;
    size?: number;
    number: number;
    numberOfElements?: number;
    first: boolean;
    empty?: boolean;
}